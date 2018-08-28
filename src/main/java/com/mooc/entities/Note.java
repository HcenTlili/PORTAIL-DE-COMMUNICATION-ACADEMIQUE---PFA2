package com.mooc.entities;

import java.io.Serializable;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="note")
public class Note implements Serializable{
	@Id 
	private String idNote;
	
	private String etudiant;
	
	private String quiz;

	private String valeur;
	
	
	
	@PersistenceConstructor
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public Note(String etudiant, String quiz, String valeur) {
		super();
		this.etudiant = etudiant;
		this.quiz = quiz;
		this.valeur = valeur;
		
	}
	public String getIdNote() {
		return idNote;
	}
	public void setIdNote(String idNote) {
		this.idNote = idNote;
	}
	public String getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(String etudiant) {
		this.etudiant = etudiant;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
