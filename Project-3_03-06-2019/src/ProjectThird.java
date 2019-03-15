import java.util.Scanner;

public class ProjectThird {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int penny = 1;
		int nickel = 5;
		int dime = 10;
		int quarter = 25;
		
		System.out.println("Please enter the total penies: ");
		double coin = (double) sc.nextInt();
		
		
		int totalQts = (int)Math.floor(coin/quarter);
		coin -=  (totalQts * quarter);
		//System.out.println(coin);

		int totalDime =  (int)Math.floor((coin/dime));
		coin -= (totalDime * dime);
		//System.out.println(coin);

		int totalNickel = (int)Math.floor((coin/nickel));
		//System.out.println("Nickel: " + totalNickel);

		
		coin -= (totalNickel * nickel);
		//System.out.println(coin);

		int totalPenny = (int) coin;
		
		
		
		
		
		System.out.println(String.format("Total Quarters : %d |  Total Dimes: %d | Total Nickels: %d | Total Pennies: %d", totalQts,totalDime,totalNickel,totalPenny));

		
		


		
	}

}
