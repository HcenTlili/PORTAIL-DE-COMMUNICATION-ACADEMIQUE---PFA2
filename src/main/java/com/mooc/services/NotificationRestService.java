package com.mooc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.CoursRepository;
import com.mooc.dao.EnseignantRepository;
import com.mooc.dao.NoteRepository;
import com.mooc.dao.NotificationRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Enseignant;
import com.mooc.entities.Examen;
import com.mooc.entities.Note;
import com.mooc.entities.Notification;
import com.mooc.entities.Quiz;

@RestController
public class NotificationRestService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	EnseignantRepository enseignantRepository;
	
	
	
	
	
	@RequestMapping(value="/notifications", method=RequestMethod.POST)
	public void save(@RequestBody Notification notification)
	{
		notificationRepository.save(notification);
	}
	@RequestMapping(value="/notifications", method=RequestMethod.GET)
	public List<Notification> getall()
	{
		return notificationRepository.findAll();
	}
	
	@RequestMapping(value="/notifications/classe/{nomClasse}", method=RequestMethod.GET)
	public List<Notification> getByNameClass(@PathVariable String nomClasse)
	{
		List<Notification> liste1 = notificationRepository.findAll();
		List<Notification> liste2 =new ArrayList<Notification>();
		for(int i =0;i<liste1.size();i++)
		{
		
			
				if(liste1.get(i).getClasse().equals(nomClasse))
				{
					liste2.add(liste1.get(i));
				}
			
		}
		return liste2;
	}
	@RequestMapping(value="/notifications/enseignant/{username}", method=RequestMethod.GET)
	public List<Notification> getByNameEnseignant(@PathVariable String username)
	{
		List<Notification> liste1 = notificationRepository.findAll();
		Enseignant e=enseignantRepository.findByUserName(username);
		List<Notification> liste2 =new ArrayList<Notification>();
		for(int i =0;i<liste1.size();i++)
		{
		for(int j=0;j<e.getClassesId().size();j++)
		{
			
				if(liste1.get(i).getClasse().equals(e.getClassesId().get(j)))
				{
					liste2.add(liste1.get(i));
				}
		}
		}
		return liste2;
	}
	
	
	
}
