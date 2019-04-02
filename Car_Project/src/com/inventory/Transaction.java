package com.inventory;

import java.text.NumberFormat;
import java.util.Locale;

import com.car.Car;
import com.user.Buyer;
import com.user.Seller;

public class Transaction {
	private Seller seller;
	private Buyer buyer;
	private Car car;
	private boolean accept = false;
	private boolean[] option = {true,false};
	private boolean isLoad = false;
    NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);

	public Transaction() {
		
	}
	
	public Transaction(Seller seller, Buyer buyer, Car car,boolean isLoad) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.car = car;
		this.isLoad = isLoad;
		transact();
	}
	
	
	public void transact() {
		boolean notFind = true;
		/*
		 * for(Car c : buyer.getCars()) {
		 * System.out.println(c.getMake().equals(car.getMake()) &&
		 * c.getModel().equals(car.getModel()) && c.getYear() == car.getYear() &&
		 * c.getOdometer() == car.getOdometer()); if(c.getMake().equals(car.getMake())
		 * && c.getModel().equals(car.getModel()) && c.getYear() == car.getYear() &&
		 * c.getOdometer() == car.getOdometer()) notFind = false; }
		 */
		
		if(!isLoad) {
			int opt =  (int) Math.round( Math.random() );
			this.accept = option[opt];
			if(accept) {
					
				}
				
			this.seller.removeCar(car);
			this.buyer.addCar(car);
			this.seller.override();
		}
		
		
		
		
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public boolean[] getOption() {
		return option;
	}

	public void setOption(boolean[] option) {
		this.option = option;
	}
	
	public String toString() {
		/*
		 * if(car.isDiscount()) { //return String.
		 * format("%s %s sold %s %s %s to %s %s at %s price with discount of %d%%"
		 * ,seller.getFirstName(),seller.getLastName(),car.getMake(),car.getModel(),car.
		 * getYear(),buyer.getFirstName(),buyer.getLastName(),us.format(car.getPrice()),
		 * car.getDiscountPercent()); } else { }
		 */
		
		return String.format("%s %s sold %s %s %s to %s %s at %s price",seller.getFirstName(),seller.getLastName(),car.getMake(),car.getModel(),car.getYear(),buyer.getFirstName(),buyer.getLastName(),us.format(car.getPrice()));

	}
	
}
