package com.users;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.user.Address;
import com.user.Buyer;
import com.user.Contact;
import com.user.Seller;
import com.user.User;

public class Users {
	private List<User> users = new ArrayList<>();
	private static final String path ="D:\\users\\Desktop\\Java\\Car_Project\\src\\com\\store\\"; 
	String fileName = path+"users.txt";

	public Users() {
		super();
		loadFileUsers();
	}

	public void addUser(User user) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			bw.append(String.format("%s\r\n",user.formatData()));
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		users.add(user);
	}
	
	public void override() {
		String fileName = path+"users.txt";
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
			
			
			
			if(users.size() != 0) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));

				for(User user : users) {
					System.out.println(user.formatData());
					
					bw.append(String.format("%s\r\n",user.formatData()));
					user.override();
					
					
				}
				
				bw.close();

			}
			
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	public void loadFileUsers() {
		String fileName = path+"users.txt";
		
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNextLine()) {
				//System.out.println(inFile.nextLine());
				//System.out.println("Writing");
				User user = null;
				
				
				//return String.format("%s,%s,%s,%s,%s,%s,%d,%d,%.2f",make,model,descp,imgUrl,getDateByFormat(dateOfPurchase),getDateByFormat(dateOfAdded),odometer,year,price);
				String word = inFile.nextLine();
				String[] parsed = word.split(",");
				
				if(parsed[0].equals("buyer")) user = new Buyer();
				if(parsed[0].equals("seller")) user = new Seller();
				//String[] parsedAddress = parsed[parsed.length-1].split(" ");

				String[] contactParse = parsed[3].split(" ");
				String[] addressParse = parsed[4].split("-");
				
				user.setFirstName(parsed[1]);
				user.setLastName(parsed[2]);
				user.setContact(new Contact(contactParse[0],contactParse[1]));
				user.setAddress(new Address(addressParse[0],addressParse[1],addressParse[2],addressParse[3]));	
				user.loadFileCars();
				
				//inFile.nextLine();
				
				users.add(user);

				//student.setAddress(new Address(parsedAddress[0],parsedAddress[1],parsedAddress[2],parsedAddress[3]));
			}
			
			inFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	public void deleteUser(User user) {
		users.remove(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String usersFormat() {
		String temp = "";
		for(User user: users) {
			temp += user + "\n";
		}
		
		return temp;
	}

	@Override
	public String toString() {
		return usersFormat();
	}
	
	
}
