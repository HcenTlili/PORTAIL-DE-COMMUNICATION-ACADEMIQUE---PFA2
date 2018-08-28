package com.mooc.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.mooc.dao.ClasseRepository;
import com.mooc.dao.CoursRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Cours;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Forum;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class ForumRestService {
	
	@Autowired
	ForumRepository forumRepository;

	@RequestMapping(value="/forums", method=RequestMethod.POST)
	public void save(@RequestBody Forum forum)
	{
		forumRepository.save(forum);
	}
	@RequestMapping(value="/forums/{nomCours}", method=RequestMethod.GET)
	public Forum getForumByName(@PathVariable String nomCours)
	{
		return forumRepository.findForumByName(nomCours);
	}
	@RequestMapping(value="/forums/{message}/{username}/{nomcours}", method=RequestMethod.PUT)
	public void update(@PathVariable String message,@PathVariable String username,@PathVariable String nomcours)
	{
		Forum forum= forumRepository.findForumByName(nomcours);
		forum.getListeMessages().add(message);
		forum.getListeUtilisateurs().add(username);
		forumRepository.save(forum);
	}
}