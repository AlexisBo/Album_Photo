package outils;

import java.sql.*;

public class BDConnexion {
	private static String driver ;
	private static String url, login, passwd ;
	private static Connection connexion ;
	
	static { 
		try {driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			url = "jdbc:mysql://localhost:3306:bdd_album_photo";
			login = "GR1U5";
			passwd = "GR1U5";
			connexion = DriverManager.getConnection(url,login,passwd);
		}
		catch (Exception e) {
			// problème, on arrête le serveur
			System.out.println(e);
			System.exit(1);
		}
	}
	
	public static Connection getConnexion() {
		return connexion;
	}
	
}
