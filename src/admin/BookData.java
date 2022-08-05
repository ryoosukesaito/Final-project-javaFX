package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookData {
	
	private StringProperty id;
	private StringProperty bookName;
	private StringProperty authorName;
	private StringProperty category;
	
	public BookData(String id, String bookName, String authorName, String category) {
		this.id = new SimpleStringProperty(id);
		this.bookName = new SimpleStringProperty(bookName);
		this.authorName = new SimpleStringProperty(authorName);
		this.category = new SimpleStringProperty(category);
	}	
	
	public StringProperty idProperty() {
		return id;
	}
	public StringProperty bookNameProperty() {
		return bookName;
	}
	public StringProperty authorNameProperty() {
		return authorName;
	}
	public StringProperty categoryProperty() {
		return category;
	}

	public StringProperty getId() {
		return id;
	}

	public StringProperty getBookName() {
		return bookName;
	}

	public StringProperty getAuthorName() {
		return authorName;
	}

	public StringProperty getCategory() {
		return category;
	}
	
	

}