package com.mooc.entities;

import java.io.Serializable;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="examen")
public class Examen implements Serializable{
	@Id 
	private String idExamen;
	
	private String classeExamen;
	
	private String contenuExamen;

	
	
	
	@PersistenceConstructor
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public Examen(String classeExamen,String contenuExamen) {
		super();
		this.setClasseExamen(classeExamen);
		this.setContenuExamen(contenuExamen);
		
	}
	public String getClasseExamen() {
		return classeExamen;
	}
	public void setClasseExamen(String classeExamen) {
		this.classeExamen = classeExamen;
	}
	public String getContenuExamen() {
		return contenuExamen;
	}
	public void setContenuExamen(String contenuExamen) {
		this.contenuExamen = contenuExamen;
	}
	
	
}
