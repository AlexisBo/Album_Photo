package modele_DAO;

import java.sql.Connection;

import outils.BDConnexion;

public class AlbumDAO {
	Connection connection;
	
	public AlbumDAO() {
		try {
			connection = BDConnexion.getConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
