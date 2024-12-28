package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost, String author) {
		super(id, title, category, cost);
        this.authors = new ArrayList<String>();
        this.authors.add(author);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			
			authors.add(authorName);
			System.out.println("Author " + authorName + 
					" added.");
		} else {
			System.out.println("Author " + authorName + 
					" is already in the list.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			
			authors.remove(authorName);
			System.out.println("Author " + authorName + 
					" removed.");
		} else {
			System.out.println("Author " + authorName + 
					" not found in the list.");
		}
	}
	
	@Override
	public String toString() {
	    String authorsString = String.join(", ", this.authors); // Kết hợp danh sách tác giả thành một chuỗi
	    return "Book - " + this.getTitle() + " - " + 
	            this.getCategory() + " - " + authorsString + ": " + 
	            this.getCost() + " $";
	}

}

