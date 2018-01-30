package modele_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele_entity.Utilisateur;
import outils.BDConnexion;

public class UtilisateurDAO {
	Connection connection;

	public UtilisateurDAO() {
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
	public Utilisateur seConnecter(String log, String pass) {
		Utilisateur utilisateur = null;

		try {
			String requetePickUser = "SELECT nom FROM Utilisateur u WHERE login=? AND Mdp=?;";
			PreparedStatement requeteSt = connection.prepareStatement(requetePickUser);
			requeteSt.setString(1, log);
			requeteSt.setString(2, pass);
			utilisateur = (Utilisateur) requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}
