package com.user;

import java.util.List;

import com.car.Car;

public class Seller extends User{

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(List<Car> cars, Address address, Contact contact, String firstName, String lastName) {
		super(cars, address, contact, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seller [Cars=" + cars + ", address=" + address + ", contact=" + contact + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
	

}
