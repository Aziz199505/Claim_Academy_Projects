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
	
	public void checkOut(Book book) {
		bookLogs.add(new BookLog(book));
	}
	
	public void checkIn(Book book) throws ParseException {
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateformat3.parse("20/03/2019");
		for(int i = 0; i < bookLogs.size(); i++) {
			if(book == bookLogs.get(i).getBook()) bookLogs.get(i).setCheckInDate(date);
		}
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
