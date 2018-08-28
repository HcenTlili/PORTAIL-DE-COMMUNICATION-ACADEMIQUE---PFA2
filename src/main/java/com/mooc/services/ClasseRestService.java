package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.entities.Classe;

@RestController
public class ClasseRestService {

	@Autowired
	ClasseRepository classeRepository;
	
	
	@RequestMapping(value="/classes", method=RequestMethod.GET)
	public List<Classe> listesClasses()
	{
		return classeRepository.findAll();
	}
	@RequestMapping(value="/listesetudiants/{idClasse}", method=RequestMethod.GET)
	public List<String> getListesEtudiants(@PathVariable String idClasse)
	{
		return classeRepository.findOne(idClasse).getEtudiantsId();
	}
	@RequestMapping(value="/classes/{idClasse}", method=RequestMethod.GET)
	public Classe getClasse(@PathVariable String idClasse)
	{
		return classeRepository.findOne(idClasse);
	}
	@RequestMapping(value="/classes", method=RequestMethod.POST)
	public void save(@RequestBody Classe classe)
	{
		classeRepository.save(classe);
	}
	
	@RequestMapping(value="/classes/{idClasse}", method=RequestMethod.PUT)
	public void save(@RequestBody Classe classe , @PathVariable String idClasse)
	{
		classe.setIdClasse(idClasse);
		classeRepository.save(classe);
	}
	
	
	@RequestMapping(value="/classes/{id}", method=RequestMethod.DELETE)
	public void save(@PathVariable String idClasse)
	{
		classeRepository.delete(idClasse);
	}
	
	
}
