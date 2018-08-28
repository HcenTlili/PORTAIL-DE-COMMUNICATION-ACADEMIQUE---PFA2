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
import com.mooc.dao.EtudiantNonEnregistreRepository;
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Etudiant;
import com.mooc.entities.EtudiantNonEnregistre;
import com.mooc.entities.Fichier;
import com.mooc.entities.Forum;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class EtudiantNonEnregistreRestService {

	
	@Autowired
	EtudiantNonEnregistreRepository etudiantNonEnregistreRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	ForumRepository forumRepository;

	@RequestMapping(value="/etudiantsnonenregistre", method=RequestMethod.POST)
	public void save(@RequestBody EtudiantNonEnregistre etudiant)
	{
	
		
		etudiantNonEnregistreRepository.save(etudiant);
		
	
	}
	@RequestMapping(value="/etudiantnonenregistre/{idEtudiant}", method=RequestMethod.GET)
	public EtudiantNonEnregistre getEtudiant(@PathVariable String idEtudiant)
	{
		return etudiantNonEnregistreRepository.findOne(idEtudiant);
	}	
	@RequestMapping(value="/etudiantnonenregistre/{idEtudiant}/{idClasse}", method=RequestMethod.POST)
	public void confirmer(@PathVariable String idEtudiant,@PathVariable String idClasse)
	{
		EtudiantNonEnregistre e = etudiantNonEnregistreRepository.findOne(idEtudiant);
		Etudiant ee =new Etudiant(e.getNom(),e.getPrenom(),idClasse,e.getPhoto(),e.getDescription(),e.getAge(),
				e.getAddressMail(),e.getTelephone(),e.getUsername(),e.getPassword(),e.getDateDeCreation());
		etudiantRepository.save(ee);
		etudiantNonEnregistreRepository.delete(e);
	}	
	@RequestMapping(value="/etudiantsnonenregistre", method=RequestMethod.GET)
	public List<EtudiantNonEnregistre> findetudiantsnonconfirmes()
	{
	
		
		return etudiantNonEnregistreRepository.findAll();
		
	
	}
	@RequestMapping(value="/deletenonenregistre/{id}", method=RequestMethod.DELETE)
	public void deleteetudiantsnonconfirmes(@PathVariable String id)
	{
	
		
	 etudiantNonEnregistreRepository.delete(etudiantNonEnregistreRepository.findOne(id));
		
	
	}
	
}
