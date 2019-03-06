import java.util.*;

public class ProjectSecond {

	public static void main(String[] args) {
		System.out.println(15/4);
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter you name: ");
		String name = input.nextLine();
		
		System.out.print("Enter you age: ");
		int age = input.nextInt();
		
		String formatOutput = String.format("%s, 5 years from now, you will be %d years old", name,(age+5));
		
		System.out.println(formatOutput);
		
		

	}

}
