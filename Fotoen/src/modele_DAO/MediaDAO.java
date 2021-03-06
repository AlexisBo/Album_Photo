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

	/**
	 * @brief récupère le media selon l'id 
	 * @param idMedia
	 * @return media
	 */
	public Media getMediaById(int idMedia) {
		Media media = null;

		loadDatabase();

		try {
			String requete = "SELECT id, lien, description, id_utilisateur, id_album FROM Media WHERE id=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idMedia);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				media = new Media(rslt.getInt("id"), rslt.getString("lien"), rslt.getString("description"),
						rslt.getInt("id_utilisateur"), rslt.getInt("id_album"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return media;
	}

	/**
	 * @brief récupère les medias d'un album
	 * @param idAlbum
	 * @return medias
	 */
	public List<Media> getMediasByAlbum(int idAlbum) {
		List<Media> medias = new ArrayList<Media>();

		loadDatabase();

		try {
			String requete = "SELECT description, lien, id_utilisateur, id_album FROM Media WHERE id_album=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idAlbum);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				medias.add(new Media(rslt.getString("lien"), rslt.getString("description"),
						rslt.getInt("id_utilisateur"), rslt.getInt("id_album")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medias;
	}

	/**
	 * @brief supprimer un media
	 * @param lien
	 */
	public int supprimer(int idMedia) {
		int resultat = 0;

		loadDatabase();

		try {
			String requete = "DELETE FROM Media WHERE id = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idMedia);
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/**
	 * @brief ajouter un media
	 * @param media
	 * @return le media ajouté
	 */
	public int insert(Media media) {
		int resultat = 0;

		loadDatabase();

		try {
			PreparedStatement requeteSt = connexion.prepareStatement(
					"INSERT INTO Media (lien, description, id_utilisateur, id_album) VALUES (?, ?, ?, ?);");
			requeteSt.setString(1, media.getLien());
			requeteSt.setString(2, media.getDescription());
			requeteSt.setInt(3, media.getIdUtilisateur());
			requeteSt.setInt(4, media.getIdAlbum());
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}
