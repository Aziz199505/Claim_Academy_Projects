package Lab;

import java.util.Scanner;

public class Lab {
	//private int age;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int age = validateAge(sc);
		
	}
	
	public static int validateAge(Scanner sc) {
		int age;
		System.out.println("Please enter a number: ");

		String inputValue = sc.next();
		try {
			age = Integer.parseInt(inputValue);
		}catch(NumberFormatException e) {
			System.out.println("This is not a number: " + inputValue);
			System.out.println("Please try again!!"); 
			return validateAge(sc);
		}
		
		return age;
		
	}
}
