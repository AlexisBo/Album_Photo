package modele_entity;

public class Commentaire {

	private String commentaire;
	private enum <String> evaluation;

	public Commentaire(String commentaire, String evaluation){
		this.commentaire = commentaire;
		this.evaluation = evaluation;
	}

	public String getCommentaire() {
		return this.lien;
	}

	public void setCommentaire(String commentaire){
		this.commentaire = commentaire;
	}
}