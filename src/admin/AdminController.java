package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import databaseUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable {

	@FXML
	private TextField Book_Name;
	@FXML
	private TextField Author_Name;
	@FXML
	private ComboBox<String> Category;
	
	@FXML
	private TableView<BookData> bookDataTableView;
	@FXML
	private TableColumn<BookData, String> idColumn;
	@FXML
	private TableColumn<BookData, String> booknameColumn;
	@FXML
	private TableColumn<BookData, String> authernameColumn;
	@FXML
	private TableColumn<BookData, String> categoryColumn;
	
	@FXML
	private Button addEntryBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Button loadBtn;
	@FXML
	private Button logoutBtn;
	
	private Connection dbc;
	private ObservableList<BookData> bookData;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.dbc = dbConnection.getConnection();
		
		ObservableList<String>list = FXCollections.observableArrayList("Classics","Tragedy","SF","Fantasy","Action","Mystery","Romance","Comedy");
		this.Category.setItems(list);
		this.Category.setValue("Select a Category");
	}
	
	@FXML
	public void loadBookData(ActionEvent event) {
		String sql = "SELECT * FROM b0522.edit_tbl";
		
		Connection conn = dbc;
		this.bookData = FXCollections.observableArrayList();
		
		try {
			ResultSet resultSet = conn.createStatement().executeQuery(sql);
			
			while(resultSet.next()){
				
				this.bookData.add(new BookData(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getString(4))
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.idColumn.setCellValueFactory(new PropertyValueFactory<BookData, String>("id"));
		this.booknameColumn.setCellValueFactory(new PropertyValueFactory<BookData, String>("Book_Name"));
		this.authernameColumn.setCellValueFactory(new PropertyValueFactory<BookData, String>("Author_Name"));
		this.categoryColumn.setCellValueFactory(new PropertyValueFactory<BookData, String>("Category"));
		
		this.bookDataTableView.setItems(bookData);
//		this.bookDataTableView.setRoot((TreeItem<BookData>) bookData);;
	}
	
	@FXML
	private void addNewBook(ActionEvent event) {
		String sql = "INSERT INTO b0522.edit_tbl (Book_Name, Author_Name, Category) VALUES (?,?,?)";
		PreparedStatement statement = null;
		
		try {
			Connection conn = dbConnection.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.Book_Name.getText());
			statement.setString(2, this.Author_Name.getText());
			statement.setString(3, this.Category.getValue());
			
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
	
	@FXML
	private void clearFields(ActionEvent event) {
		this.Book_Name.setText("");
		this.Author_Name.setText("");
	}
	
	private void logout(ActionEvent event) {
		
	}
	
}