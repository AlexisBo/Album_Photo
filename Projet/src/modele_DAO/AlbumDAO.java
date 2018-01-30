package modele_DAO;

import java.sql.Connection;

import outils.BDConnexion;

public class AlbumDAO {
	Connection connection;
	
	public AlbumDAO() {
		try {
			connection = BDConnexion.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
