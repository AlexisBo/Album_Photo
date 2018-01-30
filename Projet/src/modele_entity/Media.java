package modele_entity;

public class Media {
	
	private int id;
	private String lien;
	private String description;

	public Media(String lien, String description){
		this.lien = lien;
		this.description = description;
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
}