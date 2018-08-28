package com.mooc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.EnseignantRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Enseignant;
import com.mooc.entities.Etudiant;

@RestController
public class EnseignantRestService {
	@Autowired
	EnseignantRepository enseignantRepository;

	@RequestMapping(value="/enseignants", method=RequestMethod.GET)
	public List<Enseignant> listesEnseignants()
	{
		return enseignantRepository.findAll();
	}
	@RequestMapping(value="/enseignants/username/{username}", method=RequestMethod.GET)
	public Enseignant getEnseignantByUserName(@PathVariable String username)
	{
		return enseignantRepository.findByUserName(username);
	}
	
	@RequestMapping(value="/enseignants/{idEnseignant}", method=RequestMethod.GET)
	public Enseignant getEtudiant(@PathVariable String idEnseignant)
	{
		return enseignantRepository.findOne(idEnseignant);
	}	

	@RequestMapping(value="/enseignants", method=RequestMethod.POST)
	public void save(@RequestBody Enseignant enseignant)
	{
		enseignantRepository.save(enseignant);
	}
	
	@RequestMapping(value="/enseignants/{idEnseignant}", method=RequestMethod.PUT)
	public void update(@RequestBody Enseignant enseignant , @PathVariable String idEnseignant)
	{
		enseignant.setIdEnseignant(idEnseignant);
		enseignantRepository.save(enseignant);
	}

	@RequestMapping(value="/enseignants/{idEnseignant}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String idEnseignant)
	{
		enseignantRepository.delete(idEnseignant);
	}
}
