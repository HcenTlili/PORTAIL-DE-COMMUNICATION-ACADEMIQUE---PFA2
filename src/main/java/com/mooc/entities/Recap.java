/*package com.mooc.entities;

import java.io.Serializable;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="recap")
public class Recap implements Serializable{
	@Id 
	private String idNote;
	
	private int listeClasses;
	
	private String liste;

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

	
}
*/