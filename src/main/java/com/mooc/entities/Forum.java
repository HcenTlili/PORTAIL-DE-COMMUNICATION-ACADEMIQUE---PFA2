package com.mooc.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="forum")
public class Forum implements Serializable{
	@Id 
	private String idForum;
	
	List<String> listeUtilisateurs;
	
	List<String> listeMessages;
	
	String nomCours;
	
	@PersistenceConstructor
	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceConstructor
	public Forum(String nomCours,List<String> listeUtilisateurs,List<String> listeMessages) {
		super();
		this.nomCours=nomCours;
		this.listeUtilisateurs = listeUtilisateurs;
		this.listeMessages = listeMessages;
	}

	public String getIdForum() {
		return idForum;
	}

	public void setIdForum(String idForum) {
		this.idForum = idForum;
	}

	public List<String> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<String> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	public List<String> getListeMessages() {
		return listeMessages;
	}

	public void setListeMessages(List<String> listeMessages) {
		this.listeMessages = listeMessages;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	
}
