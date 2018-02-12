package modele_entity;

public class Commentaire {

	private int id;
	private String commentaire;
	private int evaluation;
	private Utilisateur utilisateur;

	public Commentaire(String commentaire, int evaluation, Utilisateur utilisateur) {
		this.commentaire = commentaire;
		this.evaluation = evaluation;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id){
		this.id = id;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}