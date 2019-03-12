package Assigment;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	public Customer(String lastName, String name) {
		super();
		this.lastName = lastName;
		this.lastName = name;
	}


	private String name,lastName;
	private boolean checkedOut;
	private int totalNumReturn = 0;

	List<Book> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isCheckOut() {
		return checkedOut;
	}

	public void setCheckOut(boolean isCheckOut) {
		this.checkedOut = isCheckOut;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	
	public void getBook(Branch branch,Book book) {
		books.add(book);
		branch.removeBook(book);

	}
	
	public void returnBook(Branch branch,Book book) {
		this.totalNumReturn += 1;
		books.remove(book);
		branch.addBook(book);
	}
	
	public String toString() {
		return String.format("Customer Name: %s %s\nNumber of Books: %d\nTotal Number of Books Read:%d", this.name,this.lastName,this.books.size(),this.totalNumReturn);
	}

	public int getTotalNumReturn() {
		return totalNumReturn;
	}
	
	
	


}
