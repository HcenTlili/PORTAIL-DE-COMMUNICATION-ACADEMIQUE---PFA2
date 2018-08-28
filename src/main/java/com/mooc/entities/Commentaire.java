package com.mooc.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public class Commentaire implements Serializable{

	@Id
	private String idCommentaire;
	private String idPost;
	private Etudiant utilisateur;
	private String contenue;
	private int  jaime;
	
	@CreatedDate
	private Date dateDeCreation;
	
	public Commentaire(String idPost, Etudiant utilisateur, String contenue) {
		super();
		this.idPost = idPost;
		this.utilisateur = utilisateur;
		this.contenue = contenue;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(String idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public String getIdPost() {
		return idPost;
	}
	public void setIdBlog(String idPost) {
		this.idPost = idPost;
	}
	public Etudiant getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Etudiant utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public int getJaime() {
		return jaime;
	}
	public void setJaime(int jaime) {
		this.jaime = jaime;
	}
	public Date getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	
	
	
}
