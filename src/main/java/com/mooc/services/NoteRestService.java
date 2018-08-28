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
import com.mooc.dao.EtudiantRepository;
import com.mooc.dao.NoteRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Etudiant;
import com.mooc.entities.Note;
import com.mooc.entities.Quiz;

@RestController
public class NoteRestService {

	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	
	
	
	@RequestMapping(value="/notes", method=RequestMethod.POST)
	public void save(@RequestBody Note note)
	{
		noteRepository.save(note);
	}
	
	@RequestMapping(value="/etudiantsactifs", method=RequestMethod.GET)
	public List<Etudiant> etudiantsactifs()
	{
		List<Etudiant> liste1 =etudiantRepository.findAll();
		List<Note> liste2=noteRepository.findAll();
		List<Integer> liste3 =new ArrayList<Integer>();
		for(int h=0;h<30;h++)
		{
			liste3.add(h, 0);
		}
		for(int i= 0;i<liste1.size();i++)
		{
			for(int j= 0;j<liste2.size();j++)
			{
				if(liste2.get(j).getEtudiant().equals(liste1.get(i).getUsername()))	
						{
								liste3.set(i, liste3.get(i)+1);
							//	liste3.
						}
		    }
		}
		return liste1.subList(0,3);
	}
	
	
	
}
