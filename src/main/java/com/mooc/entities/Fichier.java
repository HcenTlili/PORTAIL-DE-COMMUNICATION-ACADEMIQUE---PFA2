package com.mooc.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fichier")
public class Fichier implements Serializable{
	@Id 
	private String idFichier;
	
	private String nomFichier;
	
	private String urlPath;
	
	@PersistenceConstructor
	public Fichier(String nomFichier, String urlPath) {
		super();
		this.nomFichier = nomFichier;
		this.urlPath = urlPath;
		
	}
	@PersistenceConstructor
	public Fichier(String nomFichier) {
		super();
		this.nomFichier = nomFichier;
	}

	
	public String getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(String idFichier) {
		this.idFichier = idFichier;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	public Fichier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	
	
	
	
	
	
}
