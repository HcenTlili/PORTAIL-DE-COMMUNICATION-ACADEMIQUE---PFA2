package com.mooc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="User")
public class user {

	@Id
	private String idUser;
	
	private String firstName;
	

	
	private String lastName;
	private int numero;
	
	private String mail;
	private String username;
	private String password;
	
	
	
	
	@PersistenceConstructor
	public user(String firstName, String lastName,int numero,String mail,String username,String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.numero=numero;
		this.mail=mail;
		this.username = username;
		this.password = password;
	}
	
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getNom() {
		return firstName;
	}
	public void setNom(String firstName) {
		this.firstName = firstName;
	}
	public String getPrenom() {
		return lastName;
	}
	public void setPrenom(String lastName) {
		this.lastName = lastName;
	}


	public String getIdUser() {
		return idUser;
	}


	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}


	public String getFirstName() { 
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
