package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookData {
	
	private StringProperty id;
	private StringProperty Book_Name;
	private StringProperty Author_Name;
	private StringProperty Category;
	
	public BookData(String id, String Book_Name, String Author_Name, String Category) {
		this.id = new SimpleStringProperty(id);
		this.Book_Name = new SimpleStringProperty(Book_Name);
		this.Author_Name = new SimpleStringProperty(Author_Name);
		this.Category = new SimpleStringProperty(Category);
	}	
	
	public StringProperty idProperty() {
		return id;
	}
	public StringProperty nameProperty() {
		return Book_Name;
	}
	public StringProperty departmentProperty() {
		return Author_Name;
	}
	public StringProperty salaryProperty() {
		return Category;
	}

}