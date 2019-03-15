package Assigment;

import java.util.ArrayList;
import java.util.List;


public class Branch extends Library {
	


	private String name;
	private Address address;
	//private List<Book> totalAmtBooks = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	//private List<CustomerProfile> customerProfiles = new ArrayList<>();
	
	public Branch(String name,Address address) {
		//super(libraryName);
		this.name = name;
		this.address = address;
	
		//this.totalAmtBooks = totalBooks;
		//this.customers = customers;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void removeBookForCustomer(Book book,Customer customer) {
		if(book.isCheckedOut()) {
			int index = getIndexBook(book);
			
			if(index == -1) {
				System.out.println("Book is not there. Please check it out next time");
			}else {
				customer.addBook(totalAmtBooks.get(index));
				//customer.getCustomerProfile().checkOut(totalAmtBooks.get(index));
				totalAmtBooks.remove(book);
			}
			
			
		} else {
			System.out.println(String.format("Please check it out %s to get book",book.getTitle()));
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
		customer.setCustomerProfile(new CustomerProfile(customer));
		//customerProfiles.add(new CustomerProfile(customer));
		
	}



	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
	public String toString() {
		return String.format("Branch Name:%s\n%s\nTotal Customers:%d\nTotal Books in a Branch:%d", this.name,this.address.toString(),this.customers.size(),totalAmtBooks.size());
	}


	
}
