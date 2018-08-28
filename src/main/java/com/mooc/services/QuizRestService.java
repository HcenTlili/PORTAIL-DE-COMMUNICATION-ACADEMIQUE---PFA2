package com.mooc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooc.dao.ClasseRepository;
import com.mooc.dao.CoursRepository;
import com.mooc.dao.QuizRepository;
import com.mooc.entities.Classe;
import com.mooc.entities.Quiz;

@RestController
public class QuizRestService {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	CoursRepository coursRepository;
	
	
	
	@RequestMapping(value="/quizs", method=RequestMethod.GET)
	public Quiz listesQuizs()
	{
		return quizRepository.findByUserName();
	}
	
	@RequestMapping(value="/allquizs", method=RequestMethod.GET)
	public List<Quiz> listesToutQuizs()
	{
		return quizRepository.findAll();
	}
	
	
	/*@RequestMapping(value="/quizs", method=RequestMethod.GET)
	public List<Quiz> listesQuizs()
	{
		return quizRepository.findAll();
	}*/
	
	@RequestMapping(value="/quizs", method=RequestMethod.POST)
	public void save(@RequestBody Quiz quiz)
	{
		quizRepository.save(quiz);
	}
	
	
	
	
}
