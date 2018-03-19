package modele_entity;

import java.sql.Date;

public class Commentaire {

	private int id;
	private String commentaire;
	private int evaluation;
	private int idUtilisateur;
	private int idMedia;
	private Date date;

	public Commentaire(String commentaire, int evaluation, int idUtilisateur, int idMedia, Date date) {
		setCommentaire(commentaire, evaluation, idUtilisateur, idMedia);
		this.date = date;
	}

	public Commentaire(String commentaire, int evaluation, int idUtilisateur, int idMedia) {
		setCommentaire(commentaire, evaluation, idUtilisateur, idMedia);
		this.date = new Date(new java.util.Date().getTime());
	}

	private void setCommentaire(String commentaire, int evaluation, int idUtilisateur, int idMedia) {
		this.commentaire = commentaire;
		this.evaluation = evaluation;
		this.idUtilisateur = idUtilisateur;
		this.setIdMedia(idMedia);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdMedia() {
		return idMedia;
	}

	public void setIdMedia(int idMedia) {
		this.idMedia = idMedia;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}