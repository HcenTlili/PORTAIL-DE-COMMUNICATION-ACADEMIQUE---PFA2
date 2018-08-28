package com.mooc.entities;

import java.io.Serializable;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notification")
public class Notification implements Serializable{
	@Id 
	private String idNotification;
	
	private String classe;
	
	private String contenu;

	
	
	
	
	@PersistenceConstructor
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public Notification(String classe, String contenu) {
		super();
		this.classe = classe;
		this.contenu = contenu;
		
		
	}
	public String getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(String idNotification) {
		this.idNotification = idNotification;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
