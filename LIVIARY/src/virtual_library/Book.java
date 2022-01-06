package virtual_library;

import java.io.Serializable;


public class Book implements Serializable {
	//Serializable is used so that all information changed in the shelf would remain even after closing the program
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String bookcode;
	private String bookpath;
	
	public Book() {
		//each book would have its title, author, book code and the book path which will be used in opening or reading the book file
		title = null;
		author = null;
		bookcode = null;
		bookpath = null;
	}
	public void newBook(String t, String a, String b, String f) {
		title = t;
		author = a;
		bookcode = b;
		bookpath = f;
	}
	
	public String getBookPath() {
		return bookpath;
	}
	
	public String getTitle() {
		return title;
	}

	public String bookFront() {
		//this would be used as the cover of the book once it is displayed in the shelf
		return title + "\n by" + author + "\n" + bookcode;
	}
	
	
}
