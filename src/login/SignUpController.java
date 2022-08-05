package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databaseUtil.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUpController {
	
	@FXML
	private TextField username;
	@FXML
	private TextField password1;
	@FXML
	private TextField password2;
	@FXML
	private Button tologinBtn;
	@FXML
	private Button addUserBtn;
	@FXML
	private Label wrongAlertLabel;
	
	
	
	public void passMatch(ActionEvent event) throws IOException {
		String pass1 = this.password1.getText();
		String pass2 = this.password2.getText();
		
		pass1 = "";
		pass2 = "";
		if(pass1 != pass2 ){		
			
			this.wrongAlertLabel.setText("Password is not match");
			
//		}else if (pass1 != "" || pass2 != ""){
//			this.wrongAlertLabel.setText("Password is not match");
		}else {
			this.wrongAlertLabel.setText("Successfully registered");
			addNewUser();
		}
		
	}
	
	
	@FXML
	public void addNewUser() {
		String sql = "INSERT INTO b0522.login_tbl (username, password) VALUES (?,?)";
		PreparedStatement statement = null;
		
		try {
			Connection conn = dbConnection.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.username.getText());
			statement.setString(2, this.password1.getText());
//			statement.setString(3, this.Category.getValue());
			
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void backTo(ActionEvent event) throws IOException {
		Stage stage = (Stage) this.tologinBtn.getScene().getWindow();
		stage.close();
		backToLogin();

    }
	
	public void backToLogin(){
		try {
			
			Stage regiStage = new Stage();
			FXMLLoader regiLoader = new FXMLLoader();
			Pane root = (Pane) regiLoader.load(getClass().getResource("/login/Login.fxml").openStream());
			
			Scene scene = new Scene(root);
			regiStage.setScene(scene);
			regiStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
