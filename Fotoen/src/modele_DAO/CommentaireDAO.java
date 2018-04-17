package modele_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele_entity.Commentaire;

public class CommentaireDAO extends GenericDAO {

	public CommentaireDAO() {

	}
	
	/**
	 * @brief récupérer tout les commentaires d'un utilisateur
	 * @param idUtilisateur
	 * @return commentaire
	 */
	public List<Commentaire> getCommentairesByUtilisateur(int idUtilisateur){
		List<Commentaire> commentaires = new ArrayList<Commentaire>();

		loadDatabase();

		try {
			String requete = "SELECT commentaire, evaluation, date, id_utilisateur, id_media, date FROM Commentaire WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idUtilisateur);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				commentaires.add(new Commentaire(rslt.getString("commentaire"), rslt.getInt("evaluation"), rslt.getInt("id_utilisateur"), rslt.getInt("id_media"), rslt.getDate("date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentaires;
	}
	
	/**
	 * @brief récupérer tout les commentaires d'un media
	 * @param idMedia
	 * @return commentaire
	 */
	public List<Commentaire> getCommentairesByMedia(int idMedia){
		List<Commentaire> commentaires = new ArrayList<Commentaire>();

		loadDatabase();

		try {
			String requete = "SELECT commentaire, evaluation, date, id_utilisateur, id_media, date FROM Commentaire WHERE id_media=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idMedia);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				commentaires.add(new Commentaire(rslt.getString("commentaire"), rslt.getInt("evaluation"), rslt.getInt("id_utilisateur"), rslt.getInt("id_media"), rslt.getDate("date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentaires;
	}
}
