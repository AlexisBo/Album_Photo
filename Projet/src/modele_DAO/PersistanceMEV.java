package modele_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import outils.BDConnexion;

public class PersistanceMEV {
	Connection connection;

	public PersistanceMEV() {
		try {
			connection = BDConnexion.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @brief Execute une requete qui recupere une liste de tous les
	 *        utilisateurs
	 * @return List<User>
	 * @throws SQLException
	 */
	public List<Utilisateur> initialiserUsers() throws SQLException {
		List<Utilisateur> listUsers = null;
		Statement s = connection.createStatement();
		ResultSet resultat = s.executeQuery("select * from Proprietaires");
		while (resultat.next()) {
			listUsers.add(new Utilisateur(resultat.getString("Nom"), resultat
					.getString("Login"), resultat.getString("Mdp")));
		}
		return listUsers;
	}

	/**
	 * @brief Execute une requete qui recupere un proprietaire en fonction de
	 *        son login et mdp
	 * @param [String log, String pswd]
	 * @return User
	 */
	public Utilisateur rechercherUser(String log, String pswd) throws SQLException {
		List<Utilisateur> listUsers = null;
		String requetePickUser = "SELECT Nom FROM PROPRIETAIRES WHERE login=? AND Mdp=?";
		PreparedStatement requeteSt = connection
				.prepareStatement(requetePickUser);
		requeteSt.setString(1, log);
		requeteSt.setString(2, pswd);
		ResultSet resultat = requeteSt.executeQuery();
		return (Utilisateur) resultat;
	}

	/**
	 * @brief Execute une requete qui recupere une liste de tous les
	 *        appartements
	 * @return List<Appartement>
	 * @throws SQLException
	 */
	public List<Appartement> initialiserAppartements() throws SQLException {
		List<Appartement> listApp = null;
		Statement s = connection.createStatement();
		ResultSet resultat = s.executeQuery("select * from Appartement");
		while (resultat.next()) {
			listApp.add(new Appartement(resultat.getInt("Num"), resultat
					.getString("Type"), resultat.getString("Adresse"), resultat
					.getFloat("Prix"), resultat.getBoolean("Statut"), resultat
					.getString("Proprietaire")));
		}
		return listApp;
	}

	/**
	 * @brief Execute une requete qui recupere une liste de tous les types
	 *        d'appartements
	 * @return List<TypeAppartement>
	 * @throws SQLException
	 */
	public List<TypeAppartement> initialiserTypeAppartements()
			throws SQLException {
		List<TypeAppartement> listTApp = null;
		Statement s = connection.createStatement();
		ResultSet resultat = s.executeQuery("select * from TypesAppartement");
		while (resultat.next()) {
			listTApp.add(new TypeAppartement(resultat.getString("Nom"),
					resultat.getString("Description")));
		}
		return listTApp;
	}

	/*public Appartement rechercherAppartViaNum(int NumAppart) {
		Appartement app = null;
		String requeteRechAppNum = "select * from Appartement where num = ?";
		try {
			PreparedStatement requeteSt = connection
					.prepareStatement(requeteRechAppNum);
			requeteSt.setLong(1, NumAppart);
			ResultSet resultat = requeteSt.executeQuery();
			app = new Appartement(resultat.getInt("Num"),
					resultat.getString("Type"), resultat.getString("Adresse"),
					resultat.getFloat("Prix"), resultat.getBoolean("Statut"),
					resultat.getString("Proprietaire"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return app;
	}*/

	/**
	 * @brief Execute une requete qui recupere une liste de tous les
	 *        appartements d'un type
	 * @param [String nomTypeAppart]
	 * @return List<Appartement>
	 */
	public List<Appartement> rechercherAppartViaType(String nomTypeAppart) {
		List<Appartement> listApp = null;
		String requeteRechAppViaType = "select * from Appartement where TypeAppat = ? and EtatVente = 0";
		try {
			PreparedStatement requeteSt = connection
					.prepareStatement(requeteRechAppViaType);
			requeteSt.setString(1, nomTypeAppart);
			ResultSet resultat = requeteSt.executeQuery();
			while (resultat.next()) {
				listApp.add(new Appartement(resultat.getInt("Num"), resultat
						.getString("Type"), resultat.getString("Adresse"),
						resultat.getFloat("Prix"), resultat
								.getBoolean("Statut"), resultat
								.getString("Proprietaire")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listApp;
	}

	/**
	 * @brief Execute une requete qui ajoute un appartement dans la BD et
	 *        retourne un objet crééé de type appartement
	 * @param [String typeApp, String adresse, float montantVente, String login]
	 * @return Appartement
	 * @throws SQLException
	 */
	public Appartement mettreEnVente(String typeApp, String adresse,
			float montantVente, String login) throws SQLException {
		String requeteRechAppViaType = "INSERT INTO APPARTEMENTS (Numero, TypeAppat,"
				+ " Adresse, MontantVente, EtatVente, LoginProp) VALUES (NUMERO_APPART"
				+ ".nextval, '?', '?', '?', 0, '?');";
		PreparedStatement requeteSt = connection
				.prepareStatement(requeteRechAppViaType);
		requeteSt.setString(1, typeApp);
		requeteSt.setString(2, adresse);
		requeteSt.setFloat(3, montantVente);
		// crééé l'utilisateur Bibi avant de voir si ça ça marche
		requeteSt.setString(4, "Bibi");
		// resultat = requeteSt.executeQuery();
		requeteSt.executeUpdate();

		ResultSet resultat = null;
		requeteSt = connection
				.prepareStatement("select NUMERO_APPART.CURRVAL as id from dual;");
		resultat = requeteSt.executeQuery();
		requeteSt.executeUpdate();

		return (new Appartement(resultat.getInt("id"), typeApp, adresse,
				montantVente, false, login));
	}

	/**
	 * @brief Execute une requete qui retire un appartement de la BD
	 * @param [int numApp]
	 * @throws SQLException
	 */
	public void retirerDeVente(int numAppart) throws SQLException {
		String requeteRechAppViaType = "DELETE FROM APPARTEMENTS WHERE Numero = ?";
		PreparedStatement requeteSt = connection
				.prepareStatement(requeteRechAppViaType);
		requeteSt.setInt(1, numAppart);
		requeteSt.executeUpdate();
	}

	/**
	 * @brief Execute une requete qui met a jour (vendu) un appartement de la BD
	 * @param [int numAppart, float montantVente]
	 * @throws SQLException
	 */
	public void declarerVente(int numAppart, float montantVente)
			throws SQLException {
		String requeteRechAppViaType = "UPDATE SET MontantVente = ?, EtatVente = 1 WHERE Numero = ?";
		PreparedStatement requeteSt = connection
				.prepareStatement(requeteRechAppViaType);
		requeteSt.setFloat(1, montantVente);
		requeteSt.setInt(2, numAppart);
		requeteSt.executeUpdate();
	}
}
