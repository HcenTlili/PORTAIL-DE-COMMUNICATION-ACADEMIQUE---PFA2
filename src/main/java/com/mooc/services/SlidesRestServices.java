package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.CoursRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.dao.SlidesRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Quiz;
import com.mooc.entities.Slides;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class SlidesRestServices {

	@Autowired
	SlidesRepository slidesRepository;
	

	
	
	
	
	
@RequestMapping(value="/slides", method=RequestMethod.GET)
	public List<Slides> listesSlides()
	{
		return slidesRepository.findAll();
	}
	
	
	
	
	
}
