package Assigment;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Library {
	


	private String name;
	private String location;
	//private List<Book> totalAmtBooks = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	
	
	public Branch(String name, String location) {
		//super(libraryName);
		this.name = name;
		this.location = location;
	
		//this.totalAmtBooks = totalBooks;
		//this.customers = customers;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public void removeBookForCustomer(Book book,Customer customer) {
		if(customer.isCheckOut()) {
			int index = getIndexBook(book);
			
			if(index == -1) {
				System.out.println("Book is not there. Please check it out next time");
			}else {
				customer.addBook(totalAmtBooks.get(index));
				totalAmtBooks.remove(book);
			}
			
			
		} else {
			System.out.println("Please check it out to get books");
		}
	}
	
	
	public int getIndexBook(Book book) {
		int index = -1;
		for(int i=0;i < totalAmtBooks.size(); i++) {
			if(totalAmtBooks.get(i) == book) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	public void addCustomers(Customer customer) {
		customers.add(customer);
	}



	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public String toString() {
		return String.format("Branch Name:%s\nLocation:%s\nTotal Customers:%d\nTotal Books in a Branch:%d", this.name,this.location,this.customers.size(),totalAmtBooks.size());
	}

}
