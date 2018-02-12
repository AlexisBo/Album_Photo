package modele_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modele_entity.Utilisateur;
import outils.BDConnexion;

public class UtilisateurDAO {
	Connection connexion;

	public UtilisateurDAO() {
		try {
			connexion = BDConnexion.getConnexion();
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
	public Utilisateur seConnecter(String email, String password) {
		Utilisateur utilisateur = null;

		try {
			String requetePickUser = "SELECT nom FROM Utilisateur u WHERE email=? AND mdp=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, email);
			requeteSt.setString(2, password);
			utilisateur = (Utilisateur) requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public Utilisateur sInscrire(String pseudo, String email, String mdp, String telephone/* , Date dateNaissance */) {
		Utilisateur utilisateur = null;

		try {
//			String requeteAddUser = "INSERT INTO utilisateur (pseudo, email, mdp, telephone, dateNaissance) VALUES (?, ?, ?, ?, ?);";
			String requeteAddUser = "INSERT INTO utilisateur (pseudo, email, mdp, telephone) VALUES (?, ?, ?, ?);";

			PreparedStatement requeteSt = connexion.prepareStatement(requeteAddUser);

			requeteSt.setString(1, pseudo);
			requeteSt.setString(2, email);
			requeteSt.setString(3, mdp);
			requeteSt.setString(4, telephone);
			// requeteSt.setString(5, dateNaissance);
			utilisateur = (Utilisateur) requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public Utilisateur getByPseudo(String pseudo) {
		Utilisateur utilisateur = null;
		
		try {
			String requetePickUser = "SELECT * FROM Utilisateur u WHERE pseudo=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, pseudo);
			utilisateur = (Utilisateur) requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}
