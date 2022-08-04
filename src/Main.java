

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent rootParent = FXMLLoader.load(getClass().getResource("login/Login.fxml"));
		
		primaryStage.setTitle("Employee Management System");
		primaryStage.setScene(new Scene(rootParent));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}