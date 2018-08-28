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

import com.mooc.dao.AdministrateurRepository;
import com.mooc.dao.ClasseRepository;
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.entities.Administrateur;
import com.mooc.entities.Classe;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Fichier;
import com.mooc.entities.Forum;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class AdministrateurRestService {

	
	@Autowired
	AdministrateurRepository administrateurRepository;
	
	

	
	@RequestMapping(value="/administrateurs/username/{username}", method=RequestMethod.GET)
	public Administrateur getEtudiantByUserName(@PathVariable String username)
	{
		return administrateurRepository.findByUserName(username);
	}
	
	
}
