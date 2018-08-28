package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mooc.dao.CommentaireRepository;
import com.mooc.dao.PostRepository;
import com.mooc.entities.Commentaire;
import com.mooc.entities.Post;

@RestController
public class CommentaireRestService {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value="/commentaires", method=RequestMethod.GET)
	public List<Commentaire> listesCommentaires()
	{
		return commentaireRepository.findAll();
	}
	@RequestMapping(value="/commentaires/{idCommentaire}", method=RequestMethod.GET)
	public Commentaire getClasse(@PathVariable String idCommentaire)
	{
		return commentaireRepository.findOne(idCommentaire);
	}
	@RequestMapping(value="/commentaires", method=RequestMethod.POST)
	public void save(@RequestBody Commentaire commentaire)
	{
		
		commentaireRepository.save(commentaire);
		Post post = postRepository.findOne(commentaire.getIdPost());
		post.getCommentaires().add(commentaire);
		postRepository.save(post);
		
	}
	
	@RequestMapping(value="/commentaires/{idCommentaire}", method=RequestMethod.PUT)
	public void save(@RequestBody Commentaire commentaire , @PathVariable String idCommentaire)
	{
		commentaire.setIdCommentaire(idCommentaire);
		commentaireRepository.save(commentaire);
		Post post = postRepository.findOne(commentaire.getIdPost());
		List<Commentaire> commentaires = post.getCommentaires();
		for(int i=0;i<commentaires.size();i++)
		{
			if(commentaires.get(i).equals(idCommentaire))
			{
				commentaires.set(i, commentaire);
			}
		}
		post.setCommentaires(commentaires);
		postRepository.save(post);
	}
	
	@RequestMapping(value="/commentaires/{idCommentaire}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String idCommentaire)
	{
		commentaireRepository.delete(idCommentaire);
	}
}
