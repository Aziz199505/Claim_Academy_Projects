package com.user;

import java.util.List;

import com.car.Car;

public class Buyer extends User {

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(List<Car> cars, Address address, Contact contact, String firstName, String lastName) {
		super(cars, address, contact, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Buyer [Cars=" + cars + ", address=" + address + ", contact=" + contact + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
