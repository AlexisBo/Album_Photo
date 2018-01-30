package modele_entity;

public class Commentaire {

	private String commentaire;
	private int evaluation;

	public Commentaire(String commentaire, int evaluation){
		this.commentaire = commentaire;
		this.evaluation = evaluation;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire){
		this.commentaire = commentaire;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
}