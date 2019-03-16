package coin;

import java.util.Scanner;

public class CoinProject {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Assign Variables
		int penny = 1;
		int nickel = 5;
		int dime = 10;
		int quarter = 25;
		
		System.out.println("Please enter the total penies: ");
		double coin = (double) sc.nextInt();
		
		//Calculating changes 
		//Dividing total coins by coin getting whole number and substracting to get remain repeating for all coins
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
		
		
		
		
		//Getting result
		System.out.println(String.format("Total Quarters : %d |  Total Dimes: %d | Total Nickels: %d | Total Pennies: %d", totalQts,totalDime,totalNickel,totalPenny));

		
		


		
	}

}
