package com.inventory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.car.Car;
import com.car.CarType;
import com.user.Seller;
import com.user.User;
import com.users.Users;

public class Inventory {
	private List<Seller> sellers = new ArrayList<>();
	private List<Car> cars = new ArrayList<>();
	private List<CarType> carTypes = new ArrayList();
	private String[] states;
	private Users users;
	//private static final String path ="D:\\users\\Desktop\\Java\\Car_Project\\src\\com\\store\\"; 

	
	
	public Inventory() {
		super();
	}

	public Inventory(Users users) {
		super();
		this.users = users;
	}
	
	public void addCars() {
		for(Seller seller : sellers) {
			for(Car car : seller.getCars()) {
				car.discountPrice(1);
				cars.add(car);
			}
		}
	}
	
	
	public void addSeller() {
		for(User user : users.getUsers()) {
			if(user instanceof Seller) {
				//System.out.println("Adding cars if it is seller in Inventory Class");
				sellers.add((Seller) user);
			}
		}
	}
	
	public void addCarTypes() {
		String csvFile = "https://www.epa.gov/sites/production/files/2016-07/16tstcar.csv";

	    try {
	        URL url12 = new URL(csvFile);
	        URLConnection urlConn = url12.openConnection();
	        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
	        BufferedReader buff = new BufferedReader(inStream);

	        String line = buff.readLine();
	        line  = buff.readLine();
	        String[] lines = line.split(",");
            //System.out.println(lines[3]);
            
            CarType carType = new CarType();
            carType.setMake(lines[3].toLowerCase().replace("\"", ""));
            carType.addModel(lines[4].replace("\"", ""));
            carTypes.add(carType);
            int index = 0;
	        line  = buff.readLine();

	        while (line != null) {
	        	
	        	
	            
	            lines = line.split(",");
	            if(carTypes.get(index).getMake().equals(lines[3].toLowerCase().replace("\"", ""))) {
	            	carTypes.get(index).addModel(lines[4].replace("\"", ""));
	            }else {
	            	index +=1;
	            	CarType cType =  new CarType();
	            	cType.setMake(lines[3].toLowerCase().replace("\"", ""));
	            	cType.addModel(lines[4].replace("\"", ""));
	            	carTypes.add(cType);
	            }
	            
	            //System.out.println(lines[3]);
	            line = buff.readLine();
	          
	           
	           
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
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

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	public List<CarType> getCarTypes() {
		return carTypes;
	}

	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	public String[] getStates() {
		String[] stateList = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
		return stateList;
	}
	
	
	

	
	
	
	
}
