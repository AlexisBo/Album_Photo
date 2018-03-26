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
			String requetePickUser = "SELECT id, pseudo, email, mdp, telephone, dateNaissance FROM Utilisateur WHERE email=? AND mdp=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, email);
			requeteSt.setString(2, password);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				utilisateur = new Utilisateur(rslt.getInt("id"), rslt.getString("pseudo"), rslt.getString("email"),
						rslt.getString("mdp"), rslt.getString("telephone"), rslt.getDate("dateNaissance"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public Utilisateur sInscrire(Utilisateur utilisateur) {
		loadDatabase();

		try {

			PreparedStatement requeteSt = connexion.prepareStatement(
					"INSERT INTO utilisateur (pseudo, email, mdp, telephone, dateNaissance) VALUES (?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			requeteSt.setString(1, utilisateur.getPseudo());
			requeteSt.setString(2, utilisateur.getEmail());
			requeteSt.setString(3, utilisateur.getMdp());
			requeteSt.setString(4, utilisateur.getTelephone());
			requeteSt.setDate(5, utilisateur.getDateNaissance());

			if (requeteSt.executeUpdate() != 0) {
				ResultSet rslt = requeteSt.getGeneratedKeys();

				while (rslt.next()) {
					utilisateur = new Utilisateur(rslt.getInt(1), utilisateur.getPseudo(), utilisateur.getEmail(),
							utilisateur.getMdp(), utilisateur.getTelephone(), utilisateur.getDateNaissance());
					break;
				}
				return utilisateur;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Utilisateur getUtilisateurById(int id) {
		Utilisateur utilisateur = null;

		loadDatabase();

		try {
			String requetePickUser = "SELECT id, pseudo, email, mdp, telephone, dateNaissance FROM Utilisateur WHERE id=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setInt(1, id);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				utilisateur = new Utilisateur(rslt.getInt("id"), rslt.getString("pseudo"), rslt.getString("email"),
						rslt.getString("mdp"), rslt.getString("telephone"), rslt.getDate("dateNaissance"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
}