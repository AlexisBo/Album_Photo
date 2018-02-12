package modele_entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Album extends Observable {
	private int id;
	private String nom;
	private String description;
	private int idAdmin;
	private List<Utilisateur> viewers;
	private List<Media> medias;
	
	public Album(String nom, String description, int idAdmin) {
		this.nom = nom;
		this.description = description;
		this.idAdmin = idAdmin;
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

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public List<Utilisateur> getViewers() {
		return viewers;
	}

	public void setViewers(List<Utilisateur> viewers) {
		this.viewers = viewers;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

}
