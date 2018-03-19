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
}
