package modele_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modele_entity.Utilisateur;

public class UtilisateurDAO extends GenericDAO {

	public UtilisateurDAO() {

	}

	/**
	 * @brief Prendre en compte une connexion
	 * @param [String
	 *            log, String pswd]
	 * @return vrai si l'utilisateur existe
	 */
	public Utilisateur seConnecter(String email, String password) {
		Utilisateur utilisateur = null;

		loadDatabase();

		try {
			String requetePickUser = "SELECT pseudo, email, mdp, telephone FROM Utilisateur WHERE email=? AND mdp=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, email);
			requeteSt.setString(2, password);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				utilisateur = new Utilisateur(rslt.getString("pseudo"), rslt.getString("email"), rslt.getString("mdp"),
						rslt.getString("telephone"), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public int sInscrire(Utilisateur utilisateur) {
		loadDatabase();
		int resultat = 0;

		try {
			// String requeteAddUser = "INSERT INTO utilisateur (pseudo, email, mdp,
			// telephone) VALUES (?, ?, ?, ?);";

			PreparedStatement requeteSt = connexion
					.prepareStatement("INSERT INTO utilisateur (pseudo, email, mdp, telephone) VALUES (?, ?, ?, ?);");

			requeteSt.setString(1, utilisateur.getPseudo());
			requeteSt.setString(2, utilisateur.getEmail());
			requeteSt.setString(3, utilisateur.getMdp());
			requeteSt.setString(4, utilisateur.getTelephone());
			// requeteSt.setString(5, dateNaissance);
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
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