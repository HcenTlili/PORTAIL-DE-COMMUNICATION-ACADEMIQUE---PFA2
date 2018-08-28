package com.mooc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="message")
public class Message {

	@Id
	private String idMessage;
	
	private String idUtilisateur;
	
	private String idDestinataire;
	
	private String contenue;
	
	private String dateDeCreation;
	
	private boolean lu;
	
	private boolean important;

	public Message(String idUtilisateur, String idDestinataire, String contenue,String dateDeCreation) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idDestinataire = idDestinataire;
		this.contenue = contenue;
		this.dateDeCreation = dateDeCreation;
		this.lu = false;
		this.important = false;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(String idDestinataire) {
		this.idDestinataire = idDestinataire;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	

	
}
