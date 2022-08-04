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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private TextField department;
	@FXML
	private TextField salary;
	
	@FXML
	private TableView<EmployeeData> employeeDataTableView;
	@FXML
	private TableColumn<EmployeeData, String> idColumn;
	@FXML
	private TableColumn<EmployeeData, String> nameColumn;
	@FXML
	private TableColumn<EmployeeData, String> departmentColumn;
	@FXML
	private TableColumn<EmployeeData, String> salaryColumn;
	
	@FXML
	private Button addEntryBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Button loadBtn;
	
	private Connection dbc;
	private ObservableList<EmployeeData> employeeData;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.dbc = dbConnection.getConnection();
	}
	
	@FXML
	public void loadEmployeeData(ActionEvent event) {
		String sql = "SELECT * FROM b0522.employee_tbl";
		
		Connection conn = dbc;
		this.employeeData = FXCollections.observableArrayList();
		
		try {
			ResultSet resultSet = conn.createStatement().executeQuery(sql);
			
			while(resultSet.next()){
				
				this.employeeData.add(new EmployeeData(
						resultSet.getString(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getString(4))
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.idColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("id"));
		this.nameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("name"));
		this.departmentColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("department"));
		this.salaryColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("salary"));
		
		this.employeeDataTableView.setItems(employeeData);
	}
	
	@FXML
	private void addEmployee(ActionEvent event) {
		String sql = "INSERT INTO b0522.employee_tbl (name, dept, salary) VALUES (?,?,?)";
		PreparedStatement statement = null;
		
		try {
			Connection conn = dbConnection.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.name.getText());
			statement.setString(2, this.department.getText());
			statement.setString(3, this.salary.getText());
			
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
		this.name.setText("");
		this.department.setText("");
		this.salary.setText("");
	}
	
	
}