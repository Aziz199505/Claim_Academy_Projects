package claim;

public class Apllication {
	public static void main(String args[]) {
		System.out.println("Hello World");
		
		Student student1 = new Student();
		Student student2 = new Student("Aziz","Sobirov");
		Student student3 = new Student("Johny","Cage","3145050933","455 Eaglebrooke Street",24,3.14);
		
		System.out.println(String.format("%s %s", student2.getFirstName(),student2.getLastName()));
		
		student1.setFirstName("John");
		student1.setLastName("Walker");
		
		System.out.println(String.format("%s %s", student1.getFirstName(),student1.getLastName()));
		
		
	System.out.println(String.format("Name: %s\nLast Name: %s\nCell Phone: %s\nAddress : %s\nAge: %d\nGPA : %.3f", student3.getFirstName(),student3.getLastName(),
			student3.getTelephone(),student3.getAddress(),student3.getAge(),student3.getGpa()));
	
		student1.setAge(22);
		
		System.out.println(String.format("Name:%s\nLast Name:%s\nAge : %d", student1.getFirstName(),student1.getLastName(),student1.getAge()));

	}
	
	
}
