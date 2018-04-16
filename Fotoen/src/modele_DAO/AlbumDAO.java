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

	public Album getAlbumById(int idAlbum) {
		Album album = null;

		loadDatabase();

		try {
			String requetePickUser = "SELECT nom, description, courant, date, id_utilisateur FROM Utilisateur WHERE id = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
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

	public int supprimer(int idAlbum) {
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

	public int setCourant(int idUtilisateur, int idAlbum) {
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

	public List<Album> getAlbums(int idAdmin) {
		List<Album> albums = new ArrayList<Album>();

		loadDatabase();

		try {
			String requetePickUser = "SELECT id, nom, description, courant, date, id_utilisateur FROM Album WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
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

	public List<Utilisateur> getViewersByAlbum(int id, int idAdmin) {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		loadDatabase();

		try {
			String requetePickUser = "SELECT id_viewer FROM liste_viewers_of_album WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
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
}
