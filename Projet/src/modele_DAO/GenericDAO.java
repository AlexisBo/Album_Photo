package modele_DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class GenericDAO {
	private static String driver;
	private static String url, login, passwd;
	protected static Connection connexion;

	static {
		try {
			 driver = "com.mysql.jdbc.Driver";
			//driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			url = "jdbc:mysql://localhost:3306/bdd_album_photo";
//			url = "jdbc:mysql://localhost/bdd_album_photo";
			login = "root";
			passwd = "";
		} catch (Exception e) {
			// problème, on arrête le serveur
			System.out.println(e);
			System.exit(1);
		}
	}
    
    protected void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection(url, login, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
