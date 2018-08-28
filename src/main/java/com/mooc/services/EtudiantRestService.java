package com.mooc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Fichier;
import com.mooc.entities.Forum;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class EtudiantRestService {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	ForumRepository forumRepository;
	@RequestMapping(value="/etudiants", method=RequestMethod.GET)
	public List<Etudiant> listesEtudiants()
	{
		
		return etudiantRepository.findAll();
	}
	@RequestMapping(value="/etudiants/{idEtudiant}", method=RequestMethod.GET)
	public Etudiant getEtudiant(@PathVariable String idEtudiant)
	{
		return etudiantRepository.findOne(idEtudiant);
	}	

	@RequestMapping(value="/etudiants/parclasseid/{idClasse}", method=RequestMethod.GET)
	public List<Etudiant> getEtudiantsParClasseId(@PathVariable String idClasse)
	{
		return etudiantRepository.findUsersParClasseId(idClasse);
	}
	@RequestMapping(value="/etudiants/username/{username}", method=RequestMethod.GET)
	public Etudiant getEtudiantByUserName(@PathVariable String username)
	{
		return etudiantRepository.findByUserName(username);
	}
	@RequestMapping(value="/etudiants", method=RequestMethod.POST)
	public void save(@RequestBody Etudiant etudiant)
	{
		List<Etudiant> listbyidClasse = getEtudiantsParClasseId(etudiant.getIdClasse());
		Classe classe = classeRepository.findOne(etudiant.getIdClasse());
		List<String> etudiantsidList = listbyidClasse.stream()
                .map(Etudiant::getIdEtudiant)
                .collect(Collectors.toList());
		
		etudiantRepository.save(etudiant);
		
		etudiantsidList.add(etudiant.getIdEtudiant());
		classe.setEtudiantsId(etudiantsidList);
		classeRepository.save(classe);
	}
	@RequestMapping(value="/etudiants/{idEtudiant}", method=RequestMethod.PUT)
	public void update(@RequestBody Etudiant etudiant , @PathVariable String idEtudiant)
	{
		etudiant.setIdEtudiant(idEtudiant);
		etudiantRepository.save(etudiant);
	}
	@RequestMapping(value="/connexion/{username}", method=RequestMethod.PUT)
	public void setConnected(@PathVariable String username)
	{
		Etudiant e = etudiantRepository.findByUserName(username);
		e.setEtat("connected");
		etudiantRepository.save(e);
	}
	@RequestMapping(value="/deconnexion/{username}", method=RequestMethod.PUT)
	public void setDeconnected(@PathVariable String username)
	{
		Etudiant e = etudiantRepository.findByUserName(username);
		e.setEtat("notConnected");
		etudiantRepository.save(e);
	}
	@RequestMapping(value="/etudiants/{idEtudiant}", method=RequestMethod.DELETE)
	public void save(@PathVariable String idEtudiant)
	{
		etudiantRepository.delete(idEtudiant);
	}
	@RequestMapping(value="/forums/photos/{nomcours}", method=RequestMethod.GET)
	public List<Fichier> getUsersPhotosPaths(@PathVariable String nomcours)
	{
		Forum f =forumRepository.findForumByName(nomcours);
		List<Fichier> liste1=new ArrayList<Fichier>();
		for(int i=0;i<f.getListeUtilisateurs().size();i++)
		{
			System.out.print("hcen");
			
			liste1.add(etudiantRepository.findByUserName(f.getListeUtilisateurs().get(i)).getPhoto());
		}
		return liste1;
		
	}
	
}
