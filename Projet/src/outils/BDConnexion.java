package outils;

import java.sql.*;

public class BDConnexion {
	private static String driver ;
	private static String url, login, passwd ;
	private static Connection connection ;
	
	static { 
		try {driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			url = "jdbc:oracle:thin:@vs-oracle2:1521:ORCL";
			login = "GR1U5";
			passwd = "GR1U5";
			connection = DriverManager.getConnection(url,login,passwd);
		}
		catch (Exception e) {
			// problème, on arrête le serveur
			System.out.println(e);
			System.exit(1);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
