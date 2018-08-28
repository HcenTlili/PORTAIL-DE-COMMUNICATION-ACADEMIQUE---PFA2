package com.mooc.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="quiz")
public class Quiz implements Serializable{
	


	@Id 
	private String idQuiz;
	
	private String nomcours;
	
    private List<Question> question;
    
    private String reponses;
	
    @PersistenceConstructor
	public Quiz(String idQuiz,String nomcours, List<Question> question, String reponses) {
		super();
		this.idQuiz = idQuiz;
		this.nomcours=nomcours;
		this.question = question;
		this.reponses = reponses;
	}
	@PersistenceConstructor
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@PersistenceConstructor
	public Quiz( List<Question> question) {
		super();
		
		this.question = question;
		
	}


	public String getIdQuiz() {
		return idQuiz;
	}


	public void setIdQuiz(String idQuiz) {
		this.idQuiz = idQuiz;
	}


	public List<Question> getQuestion() {
		return question;
	}


	public void setQuestion(List<Question> question) {
		this.question = question;
	}


	public String getReponses() {
		return reponses;
	}


	public void setReponses(String reponses) {
		this.reponses = reponses;
	}

	public String getNomcours() {
		return nomcours;
	}

	public void setNomcours(String nomcours) {
		this.nomcours = nomcours;
	}
	
	
}
