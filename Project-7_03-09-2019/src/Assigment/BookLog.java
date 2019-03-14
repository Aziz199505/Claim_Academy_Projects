package Assigment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLog {
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	private Book book;
	private Date checkOutDate = new Date();
	private Date checkInDate = checkOutDate;
	
	
	
	public BookLog(Book book) {
		super();
		this.book = book;
		//this.checkOutDate = checkOutDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public String totalTimeReturn() {
		//return new Date(checkOutDate.getTime() - checkInDate.getTime());
		DateFormat dateFormat = DateFormat.getDateInstance();

		long diffDays = (checkInDate.getTime() - checkOutDate.getTime() )/ (1000 * 60 * 60 * 24);
		
		return Long.toString(diffDays);

	}

	
	public String toString() {
		if(checkOutDate == checkInDate) {
			return String.format("Book %s  was checked out in %s and not been returned",book.getTitle(),dateformat.format(checkOutDate));
		} else {
			return String.format("Book %s was checked out in %s, checked in %s and returned in %s day(s)",book.getTitle(),dateformat.format(checkOutDate),dateformat.format(checkInDate),totalTimeReturn());
		}

	}
	
	
}
