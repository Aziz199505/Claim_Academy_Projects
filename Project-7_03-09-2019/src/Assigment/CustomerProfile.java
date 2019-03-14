package Assigment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerProfile {
	
	private Customer customer;
	private List<BookLog> bookLogs = new ArrayList<>();
	public CustomerProfile(Customer customer) {
		super();
		this.customer = customer;
	}
	
	
	public String logs() {
		String log = String.format("Logs for %s %s\n",customer.getName(),customer.getLastName());
		for(BookLog b: bookLogs) {
			log += b.toString() + "\n";
		}
		return log;
	}
	
	
	public String toString() {
		return logs();
	}

	public List<BookLog> getBookLogs() {
		return bookLogs;
	}

	public void setBookLogs(List<BookLog> bookLogs) {
		this.bookLogs = bookLogs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
