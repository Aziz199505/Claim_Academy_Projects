
public class ProjectThird {

	public static void main(String[] args) {
		int penny = 1;
		int nickel = 5;
		int dime = 10;
		int quarter = 25;
		
		double coin = 99;
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
		
		
		System.out.println(totalQts);
		System.out.println(totalDime);
		System.out.println(totalNickel);
		System.out.println(totalPenny);
		
		


		
	}

}
