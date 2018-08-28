package com.mooc.services;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.mooc.dao.FichierRepository;
import com.mooc.entities.Fichier;
import com.mooc.services.StorageService;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class FichierRestService {

	List<String> files = new ArrayList<String>();
	@Autowired
	StorageService storageService;
	
	@Autowired
	FichierRepository fichierRepository;
	
	@GetMapping("/fichiers")
	List<Fichier> getAllFiles()
	{
		return fichierRepository.findAll();
	}

    // Multiple file upload
    @PostMapping("/uploadfile")
    public Fichier uploadFileMulti(
            @RequestParam("uploadfile") MultipartFile file) throws Exception {
    	Fichier f = new Fichier(file.getOriginalFilename());
    	f.setUrlPath("http://localhost:8080/files/"+f.getNomFichier());
    	fichierRepository.save(f);
    	try {
    		files.add(file.getOriginalFilename());
			storageService.store(file);
			return f;
		} catch (Exception e) {
			throw new Exception("FAIL! Maybe You had uploaded the file before or the file's size > 500KB");
		}
    }
    
    @GetMapping("/getallfilesname1")
	public List<String> getListFilesName(){
		List<String> lstFiles = new ArrayList<String>();
		
		for(Fichier f:getAllFiles())
		{
				lstFiles.add(f.getNomFichier());
		}
		
		return lstFiles;
	}
    
	@GetMapping("/getallfilesname")
	public List<String> getListFiles() {
		List<String> lstFiles = new ArrayList<String>();
		List<String> filesName = getListFilesName();
		
		try{
			lstFiles = filesName.stream()
					.map(fileName -> MvcUriComponentsBuilder
							.fromMethodName(FichierRestService.class, "getFile", fileName).build().toString())
					.collect(Collectors.toList());	
		}catch(Exception e){
			throw e;
		}
		
		return lstFiles;
	}
	
	@GetMapping("/fichiers/{id}")
	public Fichier getFichierById(@PathVariable String id)
	{
		Fichier f =fichierRepository.findOne(id);
		return f; 
	}
	@RequestMapping(value="/fichiers/nom/{nomfichier}", method=RequestMethod.GET)
	public Fichier getFichierByNom(@PathVariable String nomfichier)
	{
		return fichierRepository.getfich(nomfichier);
		 
	}
	
	

	@GetMapping("/files/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}
