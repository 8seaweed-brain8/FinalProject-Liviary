package virtual_library;

import java.io.Serializable;
import java.util.*;


//this class is where the adding and the removing of books really takes place
public class Shelf implements Serializable {
	//booklist is the list of books that is in the library or in the shelf
	
	private static final long serialVersionUID = 1L;
	private List<Book> bookList;
	private Hashtable <String,String> code_titles;
	private Hashtable <String,String> code_files; 
	private Book nb;
	
	public Shelf() {
		bookList = new ArrayList<Book>();
		code_titles = new Hashtable <String, String>();
		code_files = new Hashtable <String,String>();
	}
	
	public boolean bookAdded (String t, String a, String b, String f ) {
		boolean not_repeated = false;
		if(bookList.size()!= 0) {
			String key = null;
			Enumeration<String> T = code_titles.keys();
			while (T.hasMoreElements()) {
				key = (String) T.nextElement();
				if(key.equals(t) ) {
					not_repeated = false;
				}
				else {
					not_repeated = true;
				}
			}
		}
		else {
			not_repeated = true;
		}
		
		if(not_repeated == true) {
			nb = new Book();
			nb.newBook(t, a, b, f);
			bookList.add(nb);
			code_titles.put(t,a);
			code_files.put(b,f);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean bookRemoved(String to_rem,String code) {
		boolean removed = false;
		if(bookList.size() == 0) {
			removed = false;
		}
		else if(code_titles.get(to_rem) == null || code_files.get(code) == null) {
			removed = false;
		}
		else {
			code_titles.remove(to_rem);
			code_files.remove(code);
			int index = 0;
			while(bookList.get(index).getTitle() != to_rem) {
				index++;
			}
			bookList.remove(index);
			removed = true;
		}
		return removed;
	}
	
	public List<Book> getList() {
		return bookList;
	}
	
}
