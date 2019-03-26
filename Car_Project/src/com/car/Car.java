package com.car;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.text.SimpleDateFormat;

public class Car {
	private String make,model,descp,imgUrl;
	private Date dateOfPurchase;
	private Date dateOfAdded;
	private int odometer,year;
	private double price;
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
		
	}



	public void discountPrice(int min) {
		if(min <= 10) {
			Random r = new Random();
			this.price *= r.nextInt((10 - min) + 1) + min;		
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


	public Date getDateOfAdded() {
		return dateOfAdded;
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



	@Override
	public int hashCode() {
		return Objects.hash(dateOfAdded, dateOfPurchase, descp, imgUrl, make, model, odometer, price);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(dateOfAdded, other.dateOfAdded) && Objects.equals(dateOfPurchase, other.dateOfPurchase)
				&& Objects.equals(descp, other.descp) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(make, other.make) && Objects.equals(model, other.model) && odometer == other.odometer
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
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
