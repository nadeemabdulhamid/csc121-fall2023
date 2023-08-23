

/**
 * Represents a book in a bookstore, either
 * fiction, nonfiction, or textbook ('T')
 */
class Book {
	String title;
	String author;
	int price;       // in cents 
	char kind;       // 'F', 'N', or 'T'
	
	Book(String title, String author, int price, char kind) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.kind = kind;
	}
	
}
