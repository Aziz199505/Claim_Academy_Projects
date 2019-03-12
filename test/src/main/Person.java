package main;

public class Person {
	String name,lastName;
	int age;
	public Person(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	public String toString() {
		
		return String.format("Hello, %s %s your age is %d", this.name,this.lastName,this.age);
		
	}

}
