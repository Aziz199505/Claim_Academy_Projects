package com.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.car.Car;
import com.car.CarType;
import com.user.Address;
import com.user.Buyer;
import com.user.Contact;
import com.user.Seller;
import com.user.User;
import com.users.Users;

public class Inventory {
	private List<Seller> sellers = new ArrayList<>();
	private List<Buyer> buyers = new ArrayList<>();
	private List<Car> sellerCars = new ArrayList<>();
	private List<Car> buyerCars = new ArrayList<>();
	private List<Transaction> transactions = new ArrayList<>();
	private List<CarType> carTypes = new ArrayList();
	private String[] states;
	private Users users;
	
    NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);

	private double totalProfit = 0;
	private String mostExpCar = "";
	private String mostExpCarSold = "";

	//private static final String path ="D:\\users\\Desktop\\Java\\Car_Project\\src\\com\\store\\"; 
	private static final String path ="D:\\users\\Desktop\\Java\\Car_Project\\src\\com\\store\\"; 

	
	
	public Inventory() {
		super();
	}

	public Inventory(Users users) {
		super();
		this.users = users;
	}
	
	public void addSellerCars() {
		for(Seller seller : sellers) {
			for(Car car : seller.getCars()) {
				car.discountPrice(1);
				sellerCars.add(car);
			}
		}
	}
	
	public void addBuyerCars() {
		for(Buyer buyer : buyers) {
			for(Car car : buyer.getCars()) {
				buyerCars.add(car);
			}
		}
	}
	
	
	
	public void addSeller() {
		for(User user : users.getUsers()) {
			if(user instanceof Seller) {
				//System.out.println("Adding sellerCars if it is seller in Inventory Class");
				sellers.add((Seller) user);
			}
		}
	}
	
	public void addBuyer() {
		for(User user : users.getUsers()) {
			if(user instanceof Buyer) {
				//System.out.println("Adding sellerCars if it is seller in Inventory Class");
				System.out.println(user);
				buyers.add((Buyer) user);
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
	
	public void addTransaction(String sellerEmail,String buyerEmail, String carName,boolean isLoad,boolean isExist) {
		Seller s = new Seller();
		Buyer b = new Buyer();
		Car c = new Car();
		for(User user : users.getUsers()) {
			
			
			 if(isLoad) { 
				 if(user instanceof Buyer && user.getContact().getEmail().equals(buyerEmail)) { 
					 b = (Buyer) user; 
					 for(Car car : b.getCars())  {
						 if(String.format("%s-%s-%d-%d",car.getMake(),car.getModel(),car.getYear(),car.getOdometer()).replaceAll("\\s+","").equals(carName)) c = car;
						 
					 } } }
			 
			
			if(user instanceof Seller && user.getContact().getEmail().equals(sellerEmail)) {
				s = (Seller) user;
				for(Car car : s.getCars()) {
					if(String.format("%s-%s-%d-%d", car.getMake(),car.getModel(),car.getYear(),car.getOdometer()).replaceAll("\\s+","").equals(carName)) c = car;
				}
			}
			if(user instanceof Buyer && user.getContact().getEmail().equals(buyerEmail)) b = (Buyer) user;
		}
		

		

		if(!isLoad) {
			String fileName = path + "logs.txt";
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
				bw.append(String.format("%s,%s,%s\r\n",sellerEmail,buyerEmail,carName));
				bw.close();
				
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		
		if(isLoad) {
			
			/*
			 * for(Buyer buyer: buyers) { System.out.println(buyer);
			 * if(buyer.getContact().getEmail().equals(b.getContact().getEmail())) notFound
			 * = false; }
			 */

			

		}
		
		if(c.getMake() != null && b.getFirstName() != null && s.getFirstName() != null) {
		}
		
		if(isExist) {
			buyerCars.add(c);
		}
		
		if(c.getMake() != null) transactions.add(new Transaction(s,b,c,isLoad));



		
	}
	
	public void loadTransact() {
		String fileName = path+"logs.txt";
		
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNextLine()) {
				String word = inFile.nextLine();
				String[] parsed = word.split(",");
				try {
					addTransaction(parsed[0],parsed[1],parsed[2],true,false);

				}catch(Exception ex) {
					System.out.println("Empty line");
				}
			}
			
			inFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	
	public String getTotalProfit() {
		totalProfit = 0;
		for(Car car: buyerCars) {
			//System.out.println(car);
			totalProfit += car.getPrice();
		}
		return us.format(totalProfit);
	}
	
	public int getExipred() {
		int exipred = 0;
		for(Car car: sellerCars) {
			//System.out.println(car);
			if(car.isDiscount()) exipred += 1;
		}
		return exipred;
	}
	
	
	public void addNewBuyer(Buyer buyer) {
		users.addUser(buyer);
		buyers.add(buyer);
	}
	
	public String getAveragePrice() {
		double total = 0;
		double count = 0;
		double maxSeller = 0;
		double maxBuyer = 0;
		for(Car car: sellerCars) {
			count += 1;
			total += car.getPrice();
			if(maxSeller < car.getPrice()) {
				maxSeller = car.getPrice();
				mostExpCar = String.format("%s | %s %s %s", us.format(maxSeller) ,car.getMake(),car.getModel(),car.getYear());

			}
		}
		for(Car car: buyerCars) {
			count += 1;
			total += car.getPrice();
			if(maxBuyer < car.getPrice()) {
				maxBuyer = car.getPrice();
				mostExpCarSold = String.format("%s | %s %s %s", us.format(maxBuyer) ,car.getMake(),car.getModel(),car.getYear());

			}
		}
		
		return us.format(total/count);
	}
	
	
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getMostExpCar() {
		return mostExpCar;
	}
	
	public String getMostExpCarSold() {
		return mostExpCarSold;
	}
	
	public List<Buyer> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public List<Car> getBuyerCars() {
		return buyerCars;
	}

	public void setBuyerCars(List<Car> buyerCars) {
		this.buyerCars = buyerCars;
	}

	public int totalCarsInStock() {
		return sellerCars.size();
	}
	
	

	public List<Car> getSellerCars() {
		return sellerCars;
	}

	public void setSellerCars(List<Car> cars) {
		this.sellerCars = cars;
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
