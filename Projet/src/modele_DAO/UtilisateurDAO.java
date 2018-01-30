package modele_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import outils.BDConnexion;

public class UtilisateurDAO {
	Connection connection;

	public MediaDAO() {
		try {
			connection = BDConnexion.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @brief Prendre en compte une connexion
	 * @param [String
	 *            log, String pswd]
	 * @return vrai si l'utilisateur existe
	 */
	public boolean seConnecter(String log, String pswd) {
		Utilisateur utilisateur = null;
		/*
		 * try { //ça c'est avec ta methode, mais moi j'ai créé une liste pr eviter
		 * ça utilisateur = persistance.rechercherUser(log, pswd); } catch
		 * (SQLException e) { e.printStackTrace(); } if(utilisateur == null){ return
		 * false; } return true;
		 */

		// Avec ma liste:
		int index = listeUsers.indexOf(new Utilisateur(null, log, pswd));
		if (index != -1) {
			utilisateur = listeUsers.get(index);
			return true;
		}
		return false;
	}

	/**
	 * @brief Retirer (supprimer) un media.
	 * @param [int
	 *            idMedia]
	 */
	public void retirerMedia(int idMedia) {
		try {
			String requeteRechAppViaType = "DELETE FROM MEDIA WHERE Numero = ?";
			PreparedStatement requeteSt = connection.prepareStatement(requeteRechAppViaType);
			requeteSt.setInt(1, idMedia);
			requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
