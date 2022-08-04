package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseUtil.dbConnection;

public class LoginModel {

	Connection conn = null;
	
	public LoginModel() {
		this.conn = dbConnection.getConnection();
		
		if(this.conn == null) {
			System.exit(1);
		}
	}
	
	public boolean isDatabaseConnected() {
		return this.conn != null;
	}
	
	public boolean isLogin(String username, String password) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM login_tbl WHERE username = ? AND password = ?";
		
		try {
			statement = this.conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			
			return resultSet.next();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			try {
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}