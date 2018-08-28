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

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.ExamenRepository;
import com.mooc.dao.ForumRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Cours;
import com.mooc.entities.Enseignant;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Fichier;
import com.mooc.entities.Forum;
import com.mooc.entities.Examen;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class ExamenRestService {

	@Autowired
	ExamenRepository examenRepository;
	
	@RequestMapping(value="/examens", method=RequestMethod.POST)
	public void save(@RequestBody Examen examen)
	{
		examenRepository.save(examen);
	}
	
	@RequestMapping(value="/examens/classe/{nomClasse}", method=RequestMethod.GET)
	public List<Examen> getByNameClass(@PathVariable String nomClasse)
	{
		List<Examen> liste1 = examenRepository.findAll();
		List<Examen> liste2 =new ArrayList<Examen>();
		for(int i =0;i<liste1.size();i++)
		{
		
			
				if(liste1.get(i).getClasseExamen().equals(nomClasse))
				{
					liste2.add(liste1.get(i));
				}
			
		}
		return liste2;
	}
	@RequestMapping(value="/examens", method=RequestMethod.GET)
	public List<Examen> listesEtudiants()
	{
		
		return examenRepository.findAll();
	}
	
}
