package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.car.Car;

public abstract class User {
	protected List<Car> cars = new ArrayList<Car>();
	protected Address address;
	protected Contact contact;
	protected String firstName,lastName;
	
	
	public User() {
		super();
	}


	public User(List<Car> cars, Address address, Contact contact, String firstName, String lastName) {
		super();
		this.cars = cars;
		this.address = address;
		this.contact = contact;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void removeCar(Car car) {
		cars.remove(car);
	}
	
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString() {
		return "User [Cars=" + cars + ", address=" + address + ", contact=" + contact + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	

}
