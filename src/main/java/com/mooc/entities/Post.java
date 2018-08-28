package com.mooc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Post implements Serializable{
	@Id 
	private String idPost;
	private Etudiant etudiant;
	private String titre;
	private String contenue;
	private List<Commentaire> commentaires;
	private String dateDeCreation;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Etudiant etudiant, String titre, String contenue, String dateDeCreation, List<Commentaire> commentaires) {
		super();
		this.etudiant = etudiant;
		this.titre = titre;
		this.contenue = contenue;
		this.commentaires = commentaires;
		this.dateDeCreation = dateDeCreation;
			
	}
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	
	
	
}
