package com.mooc.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="etudiantnonenregistre")
public class EtudiantNonEnregistre implements Serializable{
	@Id 
	private String idEtudiant;
	
	private String nom;
	
	private String prenom;

	
	
	private Fichier photo;
	
	private String description;
	private String username;
	private String password;
	private int age;
	
	
	private String addressMail;
	
	private String telephone;
	
	private String etat;
	private String dateDeCreation;

	
	
	@PersistenceConstructor
	public EtudiantNonEnregistre() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public EtudiantNonEnregistre(String nom, String prenom, Fichier photo, String description, int age,
			String addressMail, String telephone,String username,String password,String dateDeCreation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		
		this.photo = photo;
		this.description = description;
		this.age = age;
		this.username=username;
		this.password=password;
		this.addressMail = addressMail;
		this.telephone = telephone;
		this.dateDeCreation = dateDeCreation;
		this.etat="notConnected";
	}
	
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	public void setPhoto(Fichier photo) {
		this.photo = photo;
	}
	public String getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Fichier getPhoto() {
		return photo;
	}
	public void setIdPhoto(Fichier photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddressMail() {
		return addressMail;
	}
	public void setAddressMail(String addressMail) {
		this.addressMail = addressMail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
