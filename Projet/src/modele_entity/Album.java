package modele_entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import modele_DAO.MediaDAO;

public class Album extends Observable {
	private int id;
	private String nom;
	private String description;
	private boolean courant;
	private int idAdmin;
	private Date date;
	private List<Utilisateur> viewers;
	private List<Media> medias;
	
	public Album(String nom, String description, int idAdmin, boolean courant, Date date) {
		this.nom = nom;
		this.description = description;
		this.idAdmin = idAdmin;
		this.courant = courant;
		this.setDate(date);
		this.viewers = new ArrayList<>();
		this.medias = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCourant() {
		return courant;
	}

	public void setCourant(boolean courant) {
		this.courant = courant;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Utilisateur> getViewers() {
		return viewers;
	}

	public void setViewers(List<Utilisateur> viewers) {
		this.viewers = viewers;
	}

	public List<Media> getMedias() {
		return new MediaDAO().getMediasByAlbum(id);
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
}
