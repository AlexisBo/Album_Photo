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

	/**
	 * @param commentaire, evaluation, idUtilisateur, idMedia
	 *            the commentaire, evaluation, idUtilisateur, idMedia to set
	 */
	private void setCommentaire(String commentaire, int evaluation, int idUtilisateur, int idMedia) {
		this.commentaire = commentaire;
		this.evaluation = evaluation;
		this.idUtilisateur = idUtilisateur;
		this.setIdMedia(idMedia);
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return commentaire
	 */
	public String getCommentaire() {
		return this.commentaire;
	}

	/**
	 * @param commentaire
	 *            the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * @return evaluation
	 */
	public int getEvaluation() {
		return evaluation;
	}

	/**
	 * @param evaluation
	 *            the evaluation to set
	 */
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur
	 *            the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return idMedia
	 */
	public int getIdMedia() {
		return idMedia;
	}

	/**
	 * @param idMedia
	 *            the idMedia to set
	 */
	public void setIdMedia(int idMedia) {
		this.idMedia = idMedia;
	}

	/**
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}