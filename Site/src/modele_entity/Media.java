package modele_entity;

import java.util.ArrayList;
import java.util.List;

public class Media {


	private int id;
	private String lien;
	private String description;
	private Utilisateur utilisateur;
	private List<Commentaire> commentaires;
	
	public Media(String lien, String description, Utilisateur utilisateur) {
		this.lien = lien;
		this.description = description;
		this.utilisateur = utilisateur;
		this.commentaires = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getLien() {
		return this.lien;
	}

	public void setLien(String lien){
		this.lien = lien;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}