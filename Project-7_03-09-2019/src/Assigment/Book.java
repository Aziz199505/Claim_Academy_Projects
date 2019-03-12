package Assigment;

public class Book {
	
	private String author;
	private int isbn = (int)Math.random() * 10000000;
	private String title;
	private int numberOfPages = 60 + (int)(Math.random() * ((500 - 60) + 1));
	
	public Book(String author, int isbn, String title, int numberOfPages) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.numberOfPages = numberOfPages;
	}
	
	public Book(String author, String title) {
		super();
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	
	public String toString() {
		return String.format("Author: %s\nIsbn:%d\nTitle:%s\nNumber of Pages: %d",this.author,this.isbn,this.title,this.numberOfPages);
	}

}
