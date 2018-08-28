package com.mooc.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="slides")
public class Slides implements Serializable{
	@Id 
	private String idSlides;
	
	private List<Fichier> listeImages;
	
	
	

	
	
	
	@PersistenceConstructor
	public Slides() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public Slides(List<Fichier> listeImages) {
		super();
		this.listeImages=listeImages;
		
	}
	public String getIdSlides() {
		return idSlides;
	}
	public void setIdSlides(String idSlides) {
		this.idSlides = idSlides;
	}
	public List<Fichier> getListeImages() {
		return listeImages;
	}
	public void setListeImages(List<Fichier> listeImages) {
		this.listeImages = listeImages;
	}
	
	
	
}
