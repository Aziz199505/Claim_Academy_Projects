package Assigment;

import java.text.ParseException;
import java.util.Date;


public class Application {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//Asign Library
		Library library = new Library("Saint Louis County Library");
		
		//Assign Branches
		Library cliffBranch = new Branch("Cliff Cave Branch", new Address("5430 Telegraph Rd.","MO",63011));
		Library bridgetonBranch = new Branch("Bridgeton Trails Branch", new Address("3455 McKelvey Rd.","MO",63001));
		Library eurekaBranch = new Branch("Eureka Hills Branch", new Address("156 Eureka Towne Ctr","MO",63311));


		//Adding Branches to Library Class
		library.addBranch((Branch) cliffBranch);
		library.addBranch((Branch) bridgetonBranch);
		library.addBranch((Branch) eurekaBranch);
		
		//Assign Books
		Book book1 = new Book("Michael Morpurgo", "Alone on a Wide, Wide Sea");
		Book book2 = new Book("Colin Wilson", "Brandy of the Damned");
		Book book3 = new Book("Val McDermid", "Beneath the Bleeding");
		Book book4 = new Book("James Ellroy", "Blood's a Rover");
		Book book5 = new Book("H. E. Bates", "The Daffodil Sky");
		Book book6 = new Book("John Gunther",  "Death Be Not Proud");
		
		//library.addBook(new Book("Michael Morpurgo", (int)Math.random() * 10000000, "Alone on a Wide, Wide Sea", 60 + (int)(Math.random() * ((500 - 60) + 1))));
		
		//Adding books to library
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);
		library.addBook(book6);
		
		
		//Trasnfering books to different branches
		library.addBookToBranch((Branch) cliffBranch, book1);
		library.addBookToBranch((Branch) cliffBranch, book2);
		library.addBookToBranch((Branch) cliffBranch, book3);
		library.addBookToBranch((Branch) bridgetonBranch, book4);
		library.addBookToBranch((Branch) eurekaBranch, book5);
		//library.addBookToBranch((Branch) eurekaBranch, book6);
		
		//Checking logic make sure books has been moved from library
		System.out.println(library.getBooks().size());
		
		
		
		//Assign Customer
		Customer customer1 = new Customer("Jeff","Bezos",new Address("12 Westbroke CT", "MO", 63023));
		Customer customer2 = new Customer("Joe","Smith",new Address("414 Eaglebrooke CT", "MO", 63023));
		Customer customer3 = new Customer("Jack","Walter",new Address("312 Eaglebrooke CT", "MO", 63023));
		
		((Branch) cliffBranch).addCustomers(customer1);
		((Branch) cliffBranch).addCustomers(customer2);
		
		//Customer Check it it out
		/*
		 * customer1.setCheckOut(true); customer2.setCheckOut(true);
		 * customer3.setCheckOut(false);
		 */
		
		//Branch giving books if customer have been checked in
		
		book1.setCheckedOut(true);
		book2.setCheckedOut(true);
		book3.setCheckedOut(true);
		book4.setCheckedOut(true);

		((Branch) cliffBranch).removeBookForCustomer(book1,customer1);
		((Branch) cliffBranch).removeBookForCustomer(book2,customer2);
		((Branch) cliffBranch).removeBookForCustomer(book3,customer1);
		((Branch) cliffBranch).removeBookForCustomer(book4,customer1);

		//Check How Many books left on branch
		System.out.println(cliffBranch.getBooks().size());
		
		//Check How many books customer got
		System.out.println(customer1.getBooks().size());
		System.out.println(customer2.getBooks().size());
		
		System.out.println("===========\n");
		System.out.println(library.toString());
		System.out.println("===========\n");

		System.out.println(((Branch) cliffBranch).toString());
		System.out.println("===========\n");

		System.out.println(book1.toString());
		System.out.println("===========\n");
		System.out.println(cliffBranch.getBooks().size());

		customer1.returnBook(((Branch) cliffBranch),book3);
		System.out.println(cliffBranch.getBooks().size());

		System.out.println(customer1.toString());
		System.out.println(customer2.toString());

		
		//Date date = new Date();
		//System.out.println(date);

	}
	
	
}

