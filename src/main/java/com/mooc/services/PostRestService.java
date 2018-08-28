package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.PostRepository;
import com.mooc.entities.Post;

@RestController
public class PostRestService {

	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public List<Post> listesblogs()
	{
		return postRepository.findAll();
	}
	@RequestMapping(value="/posts/{idPost}", method=RequestMethod.GET)
	public Post getClasse(@PathVariable String idPost)
	{
		return postRepository.findOne(idPost);
	}
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public void save(@RequestBody Post post)
	{
		postRepository.save(post);
	}
	
	@RequestMapping(value="/posts/{idPost}", method=RequestMethod.PUT)
	public void save(@RequestBody Post post , @PathVariable String idPost)
	{
		post.setIdPost(idPost);
		postRepository.save(post);
	}
	
	@RequestMapping(value="/posts/{idPost}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String idPost)
	{
		postRepository.delete(idPost);
	}
	
}
