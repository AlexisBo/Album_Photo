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
	 * @param id
	 * 
	 * @return l'utilisateur qui est connecté
	 */
	public Utilisateur getUtilisateurById(int id) {
		Utilisateur utilisateur = null;

		loadDatabase();

		try {
			String requete = "SELECT id, pseudo, email, mdp, telephone, dateNaissance FROM Utilisateur WHERE id=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
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
			String requete = "SELECT id, pseudo, email, mdp, telephone, dateNaissance FROM Utilisateur WHERE email=? AND mdp=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
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

	/**
	 * @brief Prendre en compte une inscription
	 * @param utilisateur
	 */
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

	/**
	 * @brief Prendre en compte une modification sur le profil de l'utilisateur
	 * @param utilisateur
	 * @return vrai si l'utilisateur a bien été update
	 */
	public int sUpdate(Utilisateur utilisateur) {
		int resultat = 0;
		
		loadDatabase();

		try {

			PreparedStatement requeteSt = connexion.prepareStatement(				
				"UPDATE Utilisateur SET pseudo = ?, email = ?, mdp = ?, telephone = ? WHERE id = ?;",
				Statement.RETURN_GENERATED_KEYS);

			requeteSt.setString(1, utilisateur.getPseudo());
			requeteSt.setString(2, utilisateur.getEmail());
			requeteSt.setString(3, utilisateur.getMdp());
			requeteSt.setString(4, utilisateur.getTelephone());
			requeteSt.setInt(5, utilisateur.getId());

			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}

	/**
	 * @brief supprimer un utilisateur
	 * @param idUtilisateur
	 */
	public int supprimer(int idUtilisateur) {
	//supprimer utilisateur
		int resultat = 0;

		loadDatabase();

		try {
			PreparedStatement requeteUtilisateur = connexion.prepareStatement("DELETE FROM Utilisateur WHERE id = ?;");
			requeteUtilisateur.setInt(1, idUtilisateur);
			PreparedStatement requeteMedia = connexion.prepareStatement("DELETE FROM Media WHERE id_utilisateur = ?;");
			requeteMedia.setInt(1, idUtilisateur);
			PreparedStatement requeteViewers = connexion.prepareStatement("DELETE FROM liste_viewers_of_album WHERE id_utilisateur = ?;");
			requeteViewers.setInt(1, idUtilisateur);
			PreparedStatement requeteCommentaire = connexion.prepareStatement("DELETE FROM Commentaire WHERE id_utilisateur = ?;");
			requeteCommentaire.setInt(1, idUtilisateur);
			PreparedStatement requeteAlbum = connexion.prepareStatement("DELETE FROM Album WHERE id_utilisateur = ?;");
			requeteAlbum.setInt(1, idUtilisateur);

			requeteMedia.executeUpdate();
			requeteViewers.executeUpdate();
			requeteCommentaire.executeUpdate();
			requeteAlbum.executeUpdate();
			
			resultat = requeteUtilisateur.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}