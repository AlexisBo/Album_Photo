package modele_entity;

import java.sql.Date;
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

	private void setMedia(String lien, String description, int idUtilisateur, int idAlbum) {
		this.lien = lien;
		this.description = description;
		this.idUtilisateur = idUtilisateur;
		this.idAlbum = idAlbum;
		this.commentaires = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLien() {
		return this.lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public List<Commentaire> getCommentaires() {
		return new CommentaireDAO().getCommentairesByMedia(id);
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}