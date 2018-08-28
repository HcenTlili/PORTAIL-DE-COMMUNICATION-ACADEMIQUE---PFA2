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
import com.mooc.dao.FichierRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Cours;
import com.mooc.entities.Forum;
import com.mooc.entities.Quiz;
import com.mooc.entities.Fichier;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CoursRestServices {

	@Autowired
	CoursRepository coursRepository;
	
	@Autowired
	ClasseRepository classeRepository;
	
	@Autowired
	ForumRepository forumRepository;
	
	@Autowired
	FichierRepository fichierRepository;
	
	@Autowired
	QuizRepository quizRepository;
	
	@RequestMapping(value="/cours", method=RequestMethod.GET)
	public List<Cours> listescours()
	{
		return coursRepository.findAll();
	}
	@RequestMapping(value="/cours/{idCours}", method=RequestMethod.GET)
	public Cours getCours(@PathVariable String idCours)
	{
		return coursRepository.findOne(idCours);
	}	

	@RequestMapping(value="/cours", method=RequestMethod.POST)
	public void save(@RequestBody Cours cours)
	{
		List<String> s=new ArrayList<String>();
		List<String> t=new ArrayList<String>();
		
		Forum f= new Forum(cours.getNomCours(), s,t);
		forumRepository.save(f);
		coursRepository.save(cours);
		List<String> classesId = cours.getClassesId();
		for(String id:classesId)
		{
			Classe c = classeRepository.findOne(id);
			c.getListeCours().add(cours);
			classeRepository.save(c);
			
		}
	
		
	}
	@RequestMapping(value="/cours/{fileName:.+}", method=RequestMethod.POST)
	public void save(@RequestBody List<String> s , @PathVariable String fileName)
	{
		Cours c = new Cours();
		
		List<String> h = new ArrayList<String>();
			for(int i=0;i<s.size();i++)
			{ System.out.println(s.get(i));
				h.add(s.get(i));
			}
		
		c.setClassesId(h);
		c.setNomCours(fileName);
		//System.out.println(fileName);
		// String a= fileName.substring(0,fileName.indexOf('.'))+"."
		Fichier f = fichierRepository.getfich(fileName);
		// System.out.println(f.getIdFichier());
		c.setDocument(f);
		coursRepository.save(c);
	}
	
	@RequestMapping(value="/cours/{idCours}", method=RequestMethod.PUT)
	public void update(@RequestBody Cours cours , @PathVariable String idCours)
	{
		cours.setIdCours(idCours);
		coursRepository.save(cours);
	}

	@RequestMapping(value="/cours/{idCours}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String idCours)
	{
		coursRepository.delete(idCours);
	}
	@RequestMapping(value="/cours/classe/{nomClasse}", method=RequestMethod.GET)
	public List<Cours> getByNameClass(@PathVariable String nomClasse)
	{
		List<Cours> liste1 = coursRepository.findAll();
		List<Cours> liste2 =new ArrayList<Cours>();
		for(int i =0;i<liste1.size();i++)
		{
			List<String> listeClasses = liste1.get(i).getClassesId();
			for(int j=0;j<listeClasses.size();j++)
			{
				if(listeClasses.get(j).equals(nomClasse))
				{
					liste2.add(liste1.get(i));
				}
			}
		}
		return liste2;
	}
	
	@RequestMapping(value="/quizs/classe/{nomClasse}", method=RequestMethod.GET)
	public List<Quiz> getQuizsByNameClass(@PathVariable String nomClasse)
	{
		List<Cours> liste1 = coursRepository.findAll();
		List<Cours> liste2 =new ArrayList<Cours>();
		List<Quiz> liste3 =quizRepository.findAll();
		for(int i =0;i<liste1.size();i++)
		{
			List<String> listeClasses = liste1.get(i).getClassesId();
			for(int j=0;j<listeClasses.size();j++)
			{
				if(listeClasses.get(j).equals(nomClasse))
				{
					liste2.add(liste1.get(i));
				}
			}
		}
		List<Quiz> listequizsFinale=new ArrayList<Quiz>();
		for(int i=0;i<liste3.size();i++){
			for(int j=0;j<liste2.size();j++){
				if(liste3.get(i).getNomcours().equals(liste2.get(j).getNomCours()))
				{
					listequizsFinale.add(liste3.get(i));
				}
			}
		}
		return listequizsFinale;
	}
	
}
