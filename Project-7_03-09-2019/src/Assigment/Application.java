package Assigment;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Asign Library
		Library library = new Library("Saint Louis County Library");
		
		//Assign Branches
		Library cliffBranch = new Branch("Cliff Cave Branch", "5430 Telegraph Rd.");
		Library bridgetonBranch = new Branch("Bridgeton Trails Branch", "3455 McKelvey Rd.");
		Library eurekaBranch = new Branch("Eureka Hills Branch", "156 Eureka Towne Ctr");


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
		Customer customer1 = new Customer("Jeff","Bezos");
		Customer customer2 = new Customer("Joe","Smith");
		Customer customer3 = new Customer("Jack","Walter");
		
		((Branch) cliffBranch).addCustomers(customer1);
		((Branch) cliffBranch).addCustomers(customer2);
		
		//Customer Check it it out
		customer1.setCheckOut(true);
		customer2.setCheckOut(true);
		customer3.setCheckOut(false);
		
		//Branch giving books if customer have been checked in
		((Branch) cliffBranch).removeBookForCustomer(book1,customer1);
		((Branch) cliffBranch).removeBookForCustomer(book1,customer2);

		//Check How Many books left on branch
		System.out.println(cliffBranch.getBooks().size());
		
		//Check How many books customer got
		System.out.println(customer1.books.size());
		System.out.println(customer2.books.size());
		
		
		

	}
	
	
}

