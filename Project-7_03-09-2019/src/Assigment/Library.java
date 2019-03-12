package Assigment;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	
	

	protected List<Book> totalAmtBooks = new ArrayList<>();
	private List<Branch> totalBranch = new ArrayList<>();
	private String name;
	
	public Library(String name) {
		//super();
		this.name = name;
	}
	
	public Library() {
		
	}
	
	public void addBook(Book book) {
		totalAmtBooks.add(book);
	}
	
	public void removeBook(Book book) {
		totalAmtBooks.remove(book);
	}

	public List<Book> getBooks() {
		return totalAmtBooks;
	}

	public void setBooks(List<Book> books) {
		this.totalAmtBooks = books;
	}
	
	public void addBookToBranch(Branch branch,Book book) {
		totalAmtBooks.remove(book);
		Branch b = totalBranch.get(getIndexBranch(branch));
		b.addBook(book);

	}
	
	public void removeBookFromBranch(Branch branch,Book book) {
		totalAmtBooks.add(book);
		Branch b = totalBranch.get(getIndexBranch(branch));
		b.removeBook(book);

	}
	
	public int getIndexBranch(Branch branch) {
		int index = 0;
		for(int i = 0; i < totalBranch.size(); i++) {
			if(totalBranch.get(i) == branch) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void addBranch(Branch branch) {
		totalBranch.add(branch);
	}
	
	
	public List<Branch> getBranches() {
		return totalBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getTotalAmtBooks() {
		return totalAmtBooks;
	}

	public List<Branch> getTotalBranch() {
		return totalBranch;
	}
	
	
	public String toString() {
		return String.format("Library Name: %s", this.name);
	}
	
}
