package modele_entity;

import java.util.ArrayList;
import java.util.List;

import modele_DAO.CommentaireDAO;

public class Media {

	private int id;
	private String lien;
	private String description;
	private int idUtilisateur;
	private int idAlbum;
	private List<Commentaire> commentaires;

	public Media(String lien, String description, int idUtilisateur, int idAlbum) {
		setMedia(lien, description, idUtilisateur, idAlbum);
	}

	public Media(int id, String lien, String description, int idUtilisateur, int idAlbum) {
		this.id = id;
		setMedia(lien, description, idUtilisateur, idAlbum);
	}

	/**
	 * @param lien
	 * @param description
	 * @param idUtilisateur
	 * @param idAlbum
	 */
	private void setMedia(String lien, String description, int idUtilisateur, int idAlbum) {
		this.lien = lien;
		this.description = description;
		this.idUtilisateur = idUtilisateur;
		this.idAlbum = idAlbum;
		this.commentaires = new ArrayList<>();
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
	 * @return lien
	 */
	public String getLien() {
		return this.lien;
	}

	/**
	 * @param lien
	 *            the lien to set
	 */
	public void setLien(String lien) {
		this.lien = lien;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return idAlbum
	 */
	public int getIdAlbum() {
		return idAlbum;
	}

	/**
	 * @param idAlbum
	 *            the idAlbum to set
	 */
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	/**
	 * @return ListCommentaires
	 */
	public List<Commentaire> getCommentaires() {
		return new CommentaireDAO().getCommentairesByMedia(id);
	}

	/**
	 * @param List Commentaire
	 *            the List Commentaire to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}