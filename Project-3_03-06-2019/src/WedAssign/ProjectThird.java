package WedAssign;

import java.util.Scanner;

public class ProjectThird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1.Write a method to prompt the user to enter the radius of the circle then
		 * calculate the area and circumference of the circle.
		 */
		
	
		Scanner sc = new Scanner(System.in);
		
		
		circle(sc);
		
		
		/*
		 * 2. Write a method to prompt the user for base-width and height of a triangle,
		 * then calculate the area of the Triangle.
		 */
		
		
		triangle(sc);


		/*
		 * 3. Write a method to prompt the user for a number then display check if the
		 * number is Even or Odd.
		 */
		
		AddEven(sc);

		
		
		/*
		 * 4. Write a method to prompt the user for an Integer then display the same
		 * value with one decimal place. eg user enter "15 " result is:
		 * "You entered 15, the new value is 15.0".
		 */	
		
		displayNumWithDec(sc);
		
		
		/*
		 * 5. Write a method to prompt the user for a letter of the alphabet and display
		 * it's numerical value.
		 */
		
		displayNumValOfLetter(sc);
		
		
		/*
		 * 6. Write a method to prompt the user for a double then display the value as a
		 * whole number. eg user enter "15 .8" result is:
		 * "You entered 15.8, the new value is 16". eg user enter "15 .4" result is:
		 * "You entered 15.4, the new value is 15".
		 */
		
		
		displayDoubleWholeNumber(sc);
		
		
		/*
		 * 7. Write a method to prompt the user for 4 digits representing a year. Then
		 * determine If Year Is a Leap Year.
		 */
		
		displayLeapYear(sc);
		
	}
	
	/* ================ Methods for Display and Execute ========================== */

	
	public static void circle(Scanner sc) { 
		System.out.print("Enter the radius of a circle: ");
		double radius = sc.nextDouble();
		
		double areaOfCircle = calcAreaCircle(radius);
		double circumOfCircle = calcCircCircle(radius);
		
		System.out.println(String.format("Area of Circle:\t%.2f \nCircumference of Circle:\t%.2f", areaOfCircle,circumOfCircle));
	}
	
	
	public static void triangle(Scanner sc) {
		System.out.print("Enter the  base-width of a triangle: ");
		double baseWidthTri = sc.nextDouble();
		
		System.out.print("Enter the height of a triangle: ");
		double heightTri = sc.nextDouble();
		
		double areaOfTri = calcAreaOfTri(baseWidthTri,heightTri);

		System.out.println(String.format("Area of Triangle:\t%.2f", areaOfTri));
	}
	
	
	public static void AddEven(Scanner sc) {
		System.out.print("Enter a number to check it is even or odd: ");
		int number = sc.nextInt();
		
		System.out.println(String.format("Number is %s", isEvenOrOdd(number)));
	}
	
	public static void displayNumWithDec(Scanner sc) {
		System.out.print("Enter a Integer Number: ");
		int intNumber = sc.nextInt();
		
		System.out.println(String.format("Number with one decimal place:\t%.1f", (double) intNumber));
	}
	
	
	public static void displayNumValOfLetter(Scanner sc) {
		System.out.print("Enter a letter: ");
		char letter =  sc.next().charAt(0);
		
		System.out.println(String.format("Numberical value for %s is %d",letter,(int)letter));
	}
	
	
	public static void displayDoubleWholeNumber(Scanner sc) {
		System.out.print("Enter double number: ");
		double doubleNum = Math.round(sc.nextDouble());
		
		System.out.println(String.format("Double whole number is %d", (int)doubleNum));
	}
	
	
	public static void displayLeapYear(Scanner sc) {
		System.out.print("Enter a year to check is leap year: ");
		int year = sc.nextInt();
		
		System.out.println(String.format("Year is %d %s",year,isLeapYear(year) ? "is leap year" : "is not leap year"));
		
		
		isLeapYear(year);
	}
	
	
	
	/* ================ Methods for algorithms ========================== */
	
	//Calculate Area of Circle
	public static  double calcAreaCircle(double radius) {
		return Math.PI * Math.pow(radius, 2);
	}
	
	//Calculate Circumference of Circle
	public static double calcCircCircle(double radius) {
		return 2*Math.PI * radius;
	}
	
	//Calculate Area of Triangle
	public static double calcAreaOfTri(double baseWidth,double height) {
		return (baseWidth * height)/2;
	}
	
	//Check whether number is ODD or EVEN
	public static String isEvenOrOdd(int num) {
		return num % 2 == 0 ?  "Even" :  "Odd";
	}
	
	
	//Check to see if year is leap year or not
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) || (year % 400 == 0) &&  (year % 100 != 0) ) ? true : false;
	}

}
