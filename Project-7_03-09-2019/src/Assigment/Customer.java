package Assigment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	public Customer(String lastName, String name, Address address) {
		super();
		this.lastName = lastName;
		this.firstName = name;
		this.address = address;
	}

	private CustomerProfile customerProfile;
	private String firstName,lastName;
	private Address address;
	
	private int totalNumReturn = 0;

	private List<Book> books = new ArrayList<>();

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	public void addBook(Book book) {
		books.add(book);
		this.customerProfile.getBookLogs().add(new BookLog(book));
	}
	
	
	public void getBook(Branch branch,Book book) {
		books.add(book);
		branch.removeBook(book);

	}
	
	public void returnBook(Branch branch,Book book) throws ParseException {
		this.totalNumReturn += 1;
		books.remove(book);
		branch.addBook(book);
		this.checkIn(book);
	}
	
	
	public void checkIn(Book book) throws ParseException {
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateformat3.parse("20/03/2019");
		for(int i = 0; i < this.customerProfile.getBookLogs().size(); i++) {
			if(book == this.customerProfile.getBookLogs().get(i).getBook()) this.customerProfile.getBookLogs().get(i).setCheckInDate(date);
		}
	}
	
	public String toString() {
		return String.format("Customer Name: %s %s\nCustomer Address: %s\nNumber of Books: %d\nTotal Number of Books Read:%d\n=====LOGS===\n%s", this.firstName,this.lastName,this.address.toString(),this.books.size(),this.totalNumReturn,this.getCustomerProfile());
	}

	public int getTotalNumReturn() {
		return totalNumReturn;
	}

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	


}
