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
import com.mooc.dao.MessagePubliqueRepository;
import com.mooc.entities.Administrateur;
import com.mooc.entities.Classe;
import com.mooc.entities.Enseignant;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Fichier;
import com.mooc.entities.Forum;
import com.mooc.entities.MessagePublique;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class MessagePubliqueRestService {

	
	@Autowired
	MessagePubliqueRepository messagePubliqueRepository;
	
	

	
	@RequestMapping(value="/messagespubliques", method=RequestMethod.POST)
	public void postPublicMessages(@RequestBody MessagePublique message)
	{
		 messagePubliqueRepository.save(message);
	}
	@RequestMapping(value="/messagespubliques/{id}", method=RequestMethod.PUT)
	public void postPublicMessages(@RequestBody MessagePublique message,@PathVariable String id)
	{
		message.setIdMessagePublique(id);
		 messagePubliqueRepository.save(message);
	}
	
	@RequestMapping(value="/messagespubliques/{id}", method=RequestMethod.DELETE)
	public void deleteMessage(@PathVariable String id)
	{
		messagePubliqueRepository.delete( messagePubliqueRepository.findOne(id));
	}
	
	@RequestMapping(value="/messagespubliques", method=RequestMethod.GET)
	public List<MessagePublique> getAllMessages()
	{
		return messagePubliqueRepository.findAll();
	}
	
	
}
