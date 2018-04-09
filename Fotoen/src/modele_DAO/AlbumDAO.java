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

	public Album visualiser(String nom) {
		Album album = null;

		loadDatabase();

		try {
			String requetePickUser = "SELECT nom, description, courant, date, id_utilisateur FROM Utilisateur WHERE nom = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setString(1, nom);
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

	public int supprimer(String nom) {
		int resultat = 1;

		loadDatabase();

		try {
			String requete = "DELETE FROM Album WHERE nom = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			requeteSt.setString(1, nom);
			requeteSt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public int setCourant(String nom) {
		int resultat = 0;
		
		loadDatabase();

		try {
			String requete = "UPDATE Album SET courant = 0 WHERE courant = 1;";
			String requete2 = "UPDATE Album SET courant = 1 WHERE nom = ?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requete);
			PreparedStatement requeteSt2 = connexion.prepareStatement(requete2);
			requeteSt2.setString(1, nom);
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
			String requetePickUser = "SELECT nom, description, courant, date, id_utilisateur FROM Album WHERE id_utilisateur=?;";
			PreparedStatement requeteSt = connexion.prepareStatement(requetePickUser);
			requeteSt.setInt(1, idAdmin);
			ResultSet rslt = requeteSt.executeQuery();

			while (rslt.next()) {
				albums.add(new Album(rslt.getString("nom"), rslt.getString("description"),
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

			requeteSt.setString(1, album.getNom());
			requeteSt.setString(2, album.getDescription());
			requeteSt.setBoolean(3, album.isCourant());
			requeteSt.setDate(4, album.getDate());
			requeteSt.setInt(5, album.getIdAdmin());
			resultat = requeteSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}
