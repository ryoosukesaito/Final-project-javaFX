package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {
	
	private StringProperty id;
	private StringProperty name;
	private StringProperty department;
	private StringProperty salary;
	
	public EmployeeData(String id, String name, String department, String salary) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.department = new SimpleStringProperty(department);
		this.salary = new SimpleStringProperty(salary);
	}	
	
	public StringProperty idProperty() {
		return id;
	}
	public StringProperty nameProperty() {
		return name;
	}
	public StringProperty departmentProperty() {
		return department;
	}
	public StringProperty salaryProperty() {
		return salary;
	}

}