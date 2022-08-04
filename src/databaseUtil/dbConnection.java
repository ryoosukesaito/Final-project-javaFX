package databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "Ryousuke8911";
	private static final String CONN = "jdbc:mysql://localhost:3306/a0522";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}