package com.mooc.entities;

import java.io.Serializable;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="administrateur")
public class Administrateur implements Serializable{
	@Id 
	private String idEtudiant;
	
	private String nom;
	
	private String prenom;

	private String idClasse;
	
	private Fichier photo;
	
	private String Description;
	private String username;
	private String password;
	private int age;
	
	
	private String addressMail;
	
	private String telephone;
	
	private String etat;

	
	
	@PersistenceConstructor
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceConstructor
	public Administrateur(String nom, String prenom, String idClasse, Fichier photo, String description, int age,
			String addressMail, String telephone,String username,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idClasse = idClasse;
		this.photo = photo;
		Description = description;
		this.age = age;
		this.username=username;
		this.password=password;
		this.addressMail = addressMail;
		this.telephone = telephone;
		this.etat="notConnected";
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
	public String getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(String idClasse) {
		this.idClasse = idClasse;
	}
	public Fichier getPhoto() {
		return photo;
	}
	public void setIdPhoto(Fichier photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
