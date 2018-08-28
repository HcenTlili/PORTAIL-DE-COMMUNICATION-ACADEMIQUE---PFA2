package com.mooc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cours")
public class Cours implements Serializable{
	@Id
	private String idCours;
	
	private String nomCours;
	
	private String idEnseignant;
	
	private List<String> classesId;
	
	private Fichier document;
	
	private Fichier logoCours;
	
	private int nbreDeVus;
	@PersistenceConstructor
	public Cours(String nomCours, String idEnseignant, Fichier document,List<String> classesId) {
		super();
		this.nomCours = nomCours;
		this.idEnseignant = idEnseignant;
		this.document = document;
		this.classesId = classesId;
	/*	List<String> s=new ArrayList<String>();
		List<String> t=new ArrayList<String>();
		this.forum=new Forum(s,t); */
	}
//	private Forum forum;
	@PersistenceConstructor
	public Cours(String nomCours,  Fichier document,List<String> classesId, Fichier logoCours, int nbreDeVus) {
		super();
		this.nomCours = nomCours;
		//this.idEnseignant = idEnseignant;
		this.document = document;
		this.classesId = classesId;
		this.logoCours = logoCours;
		this.nbreDeVus = nbreDeVus;
	/*	List<String> s=new ArrayList<String>();
		List<String> t=new ArrayList<String>();
		this.forum=new Forum(s,t); */
	}
	
	@PersistenceConstructor
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdCours() {
		return idCours;
	}

	public void setIdCours(String idCours) {
		this.idCours = idCours;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	public String getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(String idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public Fichier getDocument() {
		return document;
	}

	public void setDocument(Fichier document) {
		this.document = document;
	}
	public List<String> getClassesId() {
		return classesId;
	}
	public void setClassesId(List<String> classesId) {
		this.classesId = classesId;
	}
	/* public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	} */
	public Fichier getLogoCours() {
		return logoCours;
	}
	public void setLogoCours(Fichier logoCours) {
		this.logoCours = logoCours;
	}
	public int getNbreDeVus() {
		return nbreDeVus;
	}
	public void setNbreDeVus(int nbreDeVus) {
		this.nbreDeVus = nbreDeVus;
	}
	
	
	
	
}
