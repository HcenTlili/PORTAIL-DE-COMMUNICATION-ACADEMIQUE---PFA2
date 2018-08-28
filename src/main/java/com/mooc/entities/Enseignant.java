package com.mooc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="enseignant")
public class Enseignant implements Serializable{
	@Id 
	private String idEnseignant;
	
	private String nom;
	
	private String prenom;
	
	private Fichier photo;

	private List<String> classesId;
	
	private List<Cours> listeCours;
	private String Description;
	private String username;
	private String password;
	private int age;
	
	private String sexe;
	private String dateDeCreation;
	private String addressMail;
	
	private String telephone;
	
	private String etat;

	@PersistenceConstructor
	public Enseignant(String nom, String prenom,Fichier photo, List<String> classesId,String Description,String username,String password,int age ,String addressMail,
			String telephone,String etat,String sexe,String dateDeCreation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classesId = classesId;
		this.listeCours = new ArrayList<Cours>();
		this.Description = Description;
		this.username = username;
		this.password=password;
		this.setPhoto(photo);
		this.age=age;
		this.addressMail=addressMail;
		this.telephone=telephone;
		this.etat="";
		this.sexe = sexe;
		this.dateDeCreation  = dateDeCreation;
	}
	@PersistenceConstructor
	public Enseignant(String nom, String prenom, List<String> classesId,String Description,String username,String password,int age ,String addressMail,String telephone,String etat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classesId = classesId;
		this.listeCours = new ArrayList<Cours>();
		this.Description = Description;
		this.username = username;
		this.password=password;
		this.age=age;
		this.addressMail=addressMail;
		this.telephone=telephone;
		this.etat="";
	}
	
	@PersistenceConstructor
	public Enseignant(String nom, String prenom, List<String> classesId,String username,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.classesId = classesId;
		this.listeCours = new ArrayList<Cours>();
		
		this.username = username;
		this.password=password;
		
	}


	
	
	@PersistenceConstructor
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	public String getIdEnseignant() {
		return idEnseignant;
	}



	public void setIdEnseignant(String idEnseignant) {
		this.idEnseignant = idEnseignant;
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



	public List<String> getClassesId() {
		return classesId;
	}



	public void setClassesId(List<String> classesId) {
		this.classesId = classesId;
	}



	public List<Cours> getListeCours() {
		return listeCours;
	}



	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
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



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Fichier getPhoto() {
		return photo;
	}

	public void setPhoto(Fichier photo) {
		this.photo = photo;
	}
	
	

}
