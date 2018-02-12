package modele_entity;

public class Media {
	
	private int id;
	private String lien;
	private String description;
	private List<Commentaire> commentaires;

	public Media(String lien, String description){
		this.lien = lien;
		this.description = description;
		this.commentaires = new ArrayList<>();
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

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}