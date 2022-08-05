package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController /*implements Initializable*/ {
	
	LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label dbStatus;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Button loginBtn;
	@FXML
	private Label loginStatus;

//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		
//		if(this.loginModel.isDatabaseConnected()) {
//			this.dbStatus.setText("Connected");
//		}else {
//			this.dbStatus.setText("Not Connected");
//		}
//		
//	}
	
	@FXML
	public void Login(ActionEvent event) {
		
		if(this.loginModel.isLogin(this.username.getText(), this.password.getText())) {
//			this.loginStatus.setText("You have successfully logged in!");
			
			Stage stage = (Stage) this.loginBtn.getScene().getWindow();
			stage.close();
			
			adminLogin();
		}else {
			this.loginStatus.setText("Wrong Credentials");
		}
	}
	
	public void adminLogin() {
		
		try {
			
			Stage adminStage = new Stage();
			FXMLLoader adminLoader = new FXMLLoader();
			Pane root = (Pane) adminLoader.load(getClass().getResource("/admin/Edit.fxml").openStream());
			
			Scene scene = new Scene(root);
//			scene.getRoot().setStyle(null);
			adminStage.setScene(scene);
			adminStage.setTitle("Admin Dashboard");
			adminStage.setResizable(false);
			adminStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
