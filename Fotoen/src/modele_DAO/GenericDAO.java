package modele_DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class GenericDAO {
	private static String driver;
	private static String url, login, passwd;
	public static final String MEDIAS_CHEMIN_ABSOLUE = "/Fotoen/WEB-INF/ressources/medias/";
	protected static Connection connexion;

	protected void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_album_photo", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
