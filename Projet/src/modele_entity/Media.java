package modele_entity;

public class Media {
	
	private String lien;
	private String description;

	public Media(String lien, String description){
		this.lien = lien;
		this.description = description;
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
}