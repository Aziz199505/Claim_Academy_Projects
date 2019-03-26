package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.car.Car;

public abstract class User {
	protected List<Car> cars = new ArrayList<Car>();
	protected Address address;
	protected Contact contact;
	protected String firstName,lastName;
	private static final String path ="D:\\users\\Desktop\\Java\\Car_Project\\src\\com\\\\store\\"; 
	protected String type;

	public User() {
		super();
	}


	public User(Address address, Contact contact, String firstName, String lastName) {
		super();
		this.address = address;
		this.contact = contact;
		this.firstName = firstName;
		this.lastName = lastName;
		loadFileCars();
	}
	
	
	public void addCar(Car car) {
		String fileName = path+"cars-"+firstName+"-"+lastName+".txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			bw.append(String.format("%s\r\n",car.formatData()));
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		cars.add(car);
	}
	
	public void override() {
		String fileName = path+"cars-"+firstName+"-"+lastName+".txt";
		try {
			File f = new File(fileName);
			if(f.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
			
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			for(Car car : cars) {
				bw.append(String.format("%s\r\n",car.formatData()));

			}
			
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void loadFileCars() {
		String fileName = path+"cars-"+firstName+"-"+lastName+".txt";

		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNextLine()) {
				//System.out.println(inFile.nextLine());
				//System.out.println("Writing");
				Car car = new Car();

				//return String.format("%s,%s,%s,%s,%s,%s,%d,%d,%.2f",make,model,descp,imgUrl,getDateByFormat(dateOfPurchase),getDateByFormat(dateOfAdded),odometer,year,price);
				String word = inFile.nextLine();
				String[] parsed = word.split(",");
				
				//String[] parsedAddress = parsed[parsed.length-1].split(" ");
				
				car.setMake(parsed[0]);
				car.setModel(parsed[1]);
				car.setDescp(parsed[2]);
				car.setImgUrl(parsed[3]);
				
				
				 if(!parsed[4].equals("null")) {
				 
				   car.setDateOfPurchase(new
				   SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(parsed[4]));
				 }
				 
				 if(!parsed[5].equals("null")) {
					 
						car.setDateOfAdded(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(parsed[5]));

					 }
				 

				car.setOdometer(Integer.parseInt(parsed[6]));
				car.setYear((Integer.valueOf(parsed[7])));
				car.setPrice(Double.valueOf(parsed[8]));
				
				//inFile.nextLine();

				cars.add(car);

				//student.setAddress(new Address(parsedAddress[0],parsedAddress[1],parsedAddress[2],parsedAddress[3]));
			}
			
			inFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeCar(Car car) {
		
		Iterator<Car> itr = cars.iterator();

		while(itr.hasNext()) {
			Car c = itr.next();
			//System.out.println(car.formatData());
			//System.out.println(c.formatData());
			
			System.out.println(String.format("%s | %s", car.formatData(),c.formatData()));
			System.out.println(car.formatData().replaceAll("\\r\\n", "").equals(c.formatData().replaceAll("\\r\\n", "")));
			if(car.formatData().equals(c.formatData())) {
				System.out.println("Yes");
				cars.remove(c);
			}
				
			
		}
		
		//cars.remove(car);
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
	
	public String formatData() {
		return String.format("%s,%s,%s,%s,%s",type,firstName,lastName,contact,address);
	}

	
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return "User [Cars=" + cars + ", address=" + address + ", contact=" + contact + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	

}
