package modele_entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import modele_DAO.AlbumDAO;
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
		setAlbum(nom, description, idAdmin, courant, date);
	}
	
	public Album(int id, String nom, String description, int idAdmin, boolean courant, Date date) {
		this.id = id;
		setAlbum(nom, description, idAdmin, courant, date);
	}
	
	/**
	 * @param nom, description, idAdmin, courant, date
	 *            the nom, description, idAdmin, courant, date to set
	 */
	private void setAlbum(String nom, String description, int idAdmin, boolean courant, Date date) {
		this.nom = nom;
		this.description = description;
		this.idAdmin = idAdmin;
		this.courant = courant;
		this.setDate(date);
		this.viewers = new ArrayList<>();
		this.medias = new ArrayList<>();
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCourant() {
		return courant;
	}

	/**
	 * @param courant
	 *            the courant to set
	 */
	public void setCourant(boolean courant) {
		this.courant = courant;
	}

	/**
	 * @return idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin
	 *            the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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

	/**
	 * @return List Viewers
	 */
	public List<Utilisateur> getViewers() {
		return new AlbumDAO().getViewersByAlbum(this.id, this.idAdmin);
	}

	/**
	 * @param List viewers
	 *            the List viewers to set
	 */
	public void setViewers(List<Utilisateur> viewers) {
		this.viewers = viewers;
	}

	/**
	 * @return List Medias
	 */
	public List<Media> getMedias() {
		return new MediaDAO().getMediasByAlbum(id);
	}

	/**
	 * @param Lsit medias
	 *            the List medias to set
	 */
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
}
