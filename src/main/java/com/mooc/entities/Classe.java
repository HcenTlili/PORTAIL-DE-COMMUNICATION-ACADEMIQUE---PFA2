package com.mooc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection="classe")
public class Classe implements Serializable{
	@Id
	private String idClasse;
	
	private List<String> etudiantsId;

	private List<Cours> listeCours;
	
	@PersistenceConstructor
	public Classe(String idClasse ,List<String> etudiantsId) {
		super();
		this.idClasse = idClasse;
		this.etudiantsId = etudiantsId;
		this.listeCours = new ArrayList<Cours>();
	}
    @PersistenceConstructor
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(String idClasse) {
		this.idClasse = idClasse;
	}

	public List<String> getEtudiantsId() {
		return etudiantsId;
	}

	public void setEtudiantsId(List<String> etudiantsId) {
		this.etudiantsId = etudiantsId;
	}
	public List<Cours> getListeCours() {
		return listeCours;
	}
	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	
	
	
	
}
