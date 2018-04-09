package modele_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele_entity.Media;

public class MediaDAO extends GenericDAO {

	public MediaDAO() {

	}
	
	public List<Media> getMediasByUtilisateur(int idUtilisateur){
		List<Media> medias = new ArrayList<Media>();

		loadDatabase();

		try {
			String requetePickUser = "SELECT description, lien, id_utilisateur, id_album FROM Media WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setInt(1, idUtilisateur);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				medias.add(new Media(rslt.getString("lien"), rslt.getString("description"), rslt.getInt("id_utilisateur"), rslt.getInt("id_album")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medias;
	}
	
	public List<Media> getMediasByAlbum(int idAlbum){
		List<Media> medias = new ArrayList<Media>();

		loadDatabase();

		try {
			String requetePickUser = "SELECT description, lien, id_utilisateur, id_album FROM Media WHERE id_album=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setInt(1, idAlbum);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				medias.add(new Media(rslt.getString("lien"), rslt.getString("description"), rslt.getInt("id_utilisateur"), rslt.getInt("id_album")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medias;
	}

	public Media visualiser(String lien) {
		Media media = null;

		loadDatabase();

		try {
			String requetePickUser = "SELECT lien, description, id_utilisateur, id_album FROM Media WHERE lien = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, lien);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				media = new Media(rslt.getString("lien"), rslt.getString("description"), rslt.getInt("id_utilisateur"),
						rslt.getInt("id_album"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return media;
	}

	public void supprimer(String lien) {

		loadDatabase();

		try {
			String requete = "DELETE FROM Media WHERE lien = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setString(1, lien);
			requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insert(Media media) {
		int resultat = 0;

		loadDatabase();

		try {

			PreparedStatement requeteSt = connexion.prepareStatement(
					"INSERT INTO Media (lien, description, id_utilisateur, id_album) VALUES (?, ?, ?, ?);");

			requeteSt.setString(1, album.getLien());
			requeteSt.setString(2, album.getDescription());
			requeteSt.setInt(5, album.getIdUtilisateur());
			requeteSt.setInt(5, album.getIdAlbum());
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}
