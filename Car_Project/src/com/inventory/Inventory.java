package com.inventory;

import java.util.ArrayList;
import java.util.List;

import com.car.Car;
import com.user.Seller;
import com.user.User;
import com.users.Users;

public class Inventory {
	private List<Car> cars = new ArrayList<>();
	private Users users;

	
	
	public Inventory() {
		super();
	}

	public Inventory(Users users) {
		super();
		this.users = users;
	}
	
	
	public void addSellerCars() {
		for(User user : users.getUsers()) {
			if(user instanceof Seller) {
				for(Car car : user.getCars()) {
					cars.add(car);
				}
			}
		}
	}
	
	
	public int totalCarsInStock() {
		return cars.size();
	}
	
	

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	
	
	
}
