package com.mooc.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.UserRepository;
import com.mooc.entities.Etudiant;
import com.mooc.entities.user;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class UserRestService {

	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<user> listesEtudiants()
	{
		
		return userRepository.findAll();
		
	}
	@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
	public user getUserByUserName(@PathVariable String username)
	{
		return userRepository.findByUserName(username);
	}
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void save(@RequestBody user user)
	{
		userRepository.save(user);
	}
	/*@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public void update(@RequestBody user user , @PathVariable String id)
	{
		user.setIdEtudiant(id);
		userRepository.save(user);
	}*/
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String id)
	{
		userRepository.delete(id);
	}
	
	
}
