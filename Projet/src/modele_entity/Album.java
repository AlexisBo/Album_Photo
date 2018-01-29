package modele_entity;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Album implements Observable {
	private int id;
	private String nom;
	private String description;
	private int idAdmin;
	private List<Utilisateur> viewers;
	
	public Album(String nom, String description, int idAdmin) {
		super();
		this.nom = nom;
		this.description = description;
		this.idAdmin = idAdmin;
		this.viewers = new ArrayList<>();
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateAllObservable() {
		
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

}
