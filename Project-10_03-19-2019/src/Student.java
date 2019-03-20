import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
	private String firstName,lastName,email;
	private Address address;
	private int age;
	private double gpa;
	private Scanner inFile;
	private static final String path ="D:\\users\\Desktop\\streams\\"; 
	
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName) {
		
	}
	
	public void saveToFile() {
		String fileName = path+email.split("@")[0]+".txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(formatData());
			bw.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static Student readToFile(String email) {
		Student student = new Student();
		String fileName = path+email.split("@")[0]+".txt";
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNext()) {
				//System.out.println(inFile.nextLine());
				String[] parsed = inFile.nextLine().split(",");
				String[] parsedAddress = parsed[parsed.length-1].split(" ");
				student.setFirstName(parsed[0]);
				student.setLastName(parsed[1]);
				student.setEmail(parsed[2]);
				student.setAge(Integer.parseInt(parsed[3]));
				student.setGpa((Double.valueOf(parsed[4])));
				
				
				
				student.setAddress(new Address(parsedAddress[0],parsedAddress[1],parsedAddress[2],parsedAddress[3]));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return student;
	}
	
	private String formatData() {
		return String.format("%s,%s,%s,%d,%.2f,%s", firstName,lastName,email,age,gpa,address);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Scanner getInFile() {
		return inFile;
	}

	public void setInFile(Scanner inFile) {
		this.inFile = inFile;
	}
	
	
	
	public String toString() {
		return String.format("First Name:%s Last Name:%s Email:%s Age:%d Gpa:%.2f Address:%s", firstName,lastName,email,age,gpa,address);
	}
	
	
	
	
	
}
