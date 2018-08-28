package com.mooc.entities;

import java.util.List;

public class Question {
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String question, List<String> reponses) {
		super();
		this.question = question;
		this.reponses = reponses;
	}
	private String question;
	private List<String> reponses;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getReponses() {
		return reponses;
	}
	public void setReponses(List<String> reponses) {
		this.reponses = reponses;
	}
	

}
