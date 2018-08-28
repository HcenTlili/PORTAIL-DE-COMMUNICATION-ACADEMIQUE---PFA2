package com.mooc.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="messagepublique")
public class MessagePublique implements Serializable{
	@Id 
	private String idMessagePublique;
	
	private String name ;
	
	
	
	private String mail;
	
	private String message;
	
	private String dateDeCreation;
	
private boolean lu;
	
	private boolean important;
	
	@PersistenceConstructor
	public MessagePublique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceConstructor
	public MessagePublique(String name,String mail , String message,String dateDeCreation) {
		super();
		this.name=name;
		this.mail = mail;
		this.message= message;
		this.dateDeCreation = dateDeCreation;
		this.lu = false;
		this.important = false;
	}
	
	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public String getIdMessagePublique() {
		return idMessagePublique;
	}

	public void setIdMessagePublique(String idMessagePublique) {
		this.idMessagePublique = idMessagePublique;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
