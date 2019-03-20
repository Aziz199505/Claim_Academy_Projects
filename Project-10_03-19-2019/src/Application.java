import java.io.File;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		
		student.setFirstName("Joe");
		student.setLastName("Smith");
		student.setAge(43);
		student.setEmail("joesmith@gmail.com");
		student.setGpa(2.5);
		//public Address(String street, String city,String state,String zipcode) {

		student.setAddress(new Address("1342 Westham Ave","Chesterfield","MO","63021"));
		
		student.saveToFile();
		
		Student student2 = student.readToFile("joesmith@gmail.com");
		System.out.println(student2);

	}

}
