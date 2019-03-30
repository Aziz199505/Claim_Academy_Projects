package com.car;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

public class Car {
	private String make,model,descp,imgUrl;
	private Date dateOfPurchase;
	private Date dateOfAdded;
	private int odometer,year;
	private double price;
	boolean discount = false;
	int discountPercent = 0;
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

	
	public Car() {
		super();
	}

	

	public Car(String make, String model,int year,
			int odometer, double price) {
		super();
		this.make = make;
		this.model = model;
		this.odometer = odometer;
		this.price = price;
		this.year = year;
		this.imgUrl = "http://www.regcheck.org.uk/image.aspx/@" +  Base64.getEncoder().encodeToString(String.format("%s %s %s", make,model,year).getBytes());
	}
	
	
	public int totalDays() {
		//return new Date(checkOutDate.getTime() - checkInDate.getTime());
		Date date = new Date();
		long diffDays = (date.getTime() - dateOfAdded.getTime() )/ (1000 * 60 * 60 * 24);
		
		return Integer.parseInt(Long.toString(diffDays));

	}


	public void discountPrice(int min) {
		System.out.println("Hello!!!!!");
		System.out.println(totalDays());
		if(totalDays() >= 120) {
			this.discount = true;
			
			if(min <= 10) {
				Random r = new Random();
				this.discountPercent = r.nextInt((10 - min) + 1) + min;
				this.price *= 1 - (discountPercent/100.00);		
			}
		}
	}

	public String getDateByFormat(Date date) {
		try{
			return dateformat.format(date);

		}catch(Exception e) {
			return "null";
		}
	}
	
	
	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getDescp() {
		return descp;
	}


	public void setDescp(String descp) {
		this.descp = descp;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}


	public String getDateOfAdded() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(dateOfAdded);
	}


	public void setDateOfAdded(Date dateOfAdded) {
		this.dateOfAdded = dateOfAdded;
	}


	public int getOdometer() {
		return odometer;
	}


	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}





	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	




	public boolean isDiscount() {
		return discount;
	}



	public void setDiscount(boolean discount) {
		this.discount = discount;
	}



	public int getDiscountPercent() {
		return discountPercent;
	}



	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}



	public String formatData() {
		return String.format("%s,%s,%s,%s,%s,%s,%d,%d,%.2f",make,model,descp,imgUrl,getDateByFormat(dateOfPurchase),getDateByFormat(dateOfAdded),odometer,year,price);
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", descp=" + descp + ", imgUrl=" + imgUrl
				+ ", dateOfPurchase=" + dateOfPurchase + ", dateOfAdded=" + dateOfAdded + ", odometer=" + odometer
				+ ", year=" + year + ", price=" + price + "]";
	}




	



	
	
	
	
	
	
}
