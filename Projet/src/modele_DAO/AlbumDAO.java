package modele_DAO;

public class AlbumDAO extends GenericDAO {

	public AlbumDAO() {

	}

	public Album visualiser(String nom) {

		loadDatabase();

		try {
			String requetePickUser = "SELECT * FROM Utilisateur WHERE nom = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, nom);
			ResultSet rslt = requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ;
	}
}
