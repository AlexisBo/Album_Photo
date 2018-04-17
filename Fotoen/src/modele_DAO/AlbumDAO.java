package modele_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele_entity.Album;
import modele_entity.Utilisateur;

public class AlbumDAO extends GenericDAO {

	public AlbumDAO() {

	}

	/**
	 * @brief récupère l'album' selon l'id 
	 * @param idAlbum
	 * @return album
	 */
	public Album getAlbumById(int idAlbum) {
	//récupérer album par id
		Album album = null;

		loadDatabase();

		try {
			String requete = "SELECT nom, description, courant, date, id_utilisateur FROM Album WHERE id = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idAlbum);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				album = new Album(rslt.getString("nom"), rslt.getString("description"), rslt.getInt("id_utilisateur"),
						rslt.getBoolean("courant"), rslt.getDate("date"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}

	/**
	 * @brief récupère l'album courant
	 * @param idUtilisateur
	 * @return album
	 */
	public Album getAlbumCurrent(int idUtilisateur) {
	//récupérer album courrant
		Album album = null;

		loadDatabase();

		try {
			String requete = "SELECT nom, description, courant, date, id_utilisateur FROM Album WHERE courant = 1 AND id_utilisateur = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idUtilisateur);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				album = new Album(rslt.getString("nom"), rslt.getString("description"), rslt.getInt("id_utilisateur"),
						rslt.getBoolean("courant"), rslt.getDate("date"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}


	/**
	 * @brief supprimer un album
	 * @param idAlbum
	 */
	public int supprimer(int idAlbum) {
	//supprimer album
		int resultat = 0;

		loadDatabase();

		try {
			String requete = "DELETE FROM Album WHERE id = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idAlbum);
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/**
	 * @brief définir un album courant
	 * @param idUtilisateur
	 * @param idAlbum
	 */
	public int setCourant(int idUtilisateur, int idAlbum) {
	//définir album courant
		int resultat = 0;
		
		loadDatabase();

		try {
			String requete = "UPDATE Album SET courant = 0 WHERE courant = 1 AND id_utilisateur = ?;";
			String requete2 = "UPDATE Album SET courant = 1 WHERE id = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			PreparedStatement requeteSt2 = connexion.prepareStatement(requete2);
			
			requeteSt.setInt(1, idUtilisateur);
			requeteSt2.setInt(1, idAlbum);
			
			requeteSt.executeUpdate();
			resultat = requeteSt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/**
	 * @brief récupérer la liste des albums de l'utilisateur
	 * @param idAdmin
	 * @return albums
	 */
	public List<Album> getAlbums(int idAdmin) {
		List<Album> albums = new ArrayList<Album>();

		loadDatabase();

		try {
			String requete = "SELECT id, nom, description, courant, date, id_utilisateur FROM Album WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idAdmin);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				albums.add(new Album(rslt.getInt("id"), rslt.getString("nom"), rslt.getString("description"),
						rslt.getInt("id_utilisateur"), rslt.getBoolean("courant"), rslt.getDate("date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}

	/**
	 * @brief ajouter un album
	 * @param album
	 */
	public int insert(Album album) {
		int resultat = 0;

		loadDatabase();

		try {

			PreparedStatement requeteSt = connexion.prepareStatement(
					"INSERT INTO Album (nom, description, courant, date, id_utilisateur) VALUES (?, ?, ?, ?, ?);");
			PreparedStatement requeteCourantExist = connexion.prepareStatement(
					"SELECT id FROM Album WHERE courant = 1 AND id_utilisateur=?;");

			requeteSt.setString(1, album.getNom());
			requeteSt.setString(2, album.getDescription());
			
			requeteCourantExist.setInt(1, album.getIdAdmin());
			ResultSet rslt = requeteCourantExist.executeQuery();
			if(rslt.next()) {
				requeteSt.setBoolean(3, false);
			} else {
				requeteSt.setBoolean(3, true);
			}
			
			requeteSt.setDate(4, album.getDate());
			requeteSt.setInt(5, album.getIdAdmin());
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/**
	 * @brief récupérer la liste des "viewers" d'un album
	 * @param idAlbum
	 * @param idAdmin
	 * @return utilisateurs
	 */
	public List<Utilisateur> getViewersByAlbum(int idAlbum, int idAdmin) {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		loadDatabase();

		try {
			String requete = "SELECT id_viewer FROM liste_viewers_of_album WHERE id=? AND id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setInt(1, idAlbum);
			requeteSt.setInt(2, idAdmin);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				utilisateurs.add(new UtilisateurDAO().getUtilisateurById(rslt.getInt("id_viewer")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}
}
