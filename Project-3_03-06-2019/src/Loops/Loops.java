package Loops;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {1,20,35};
		int[] end = {10,30,45};
		int total = 0;
		
		
		for(int k = 0; k < start.length; k++) {
			for(int i = start[k]; i <= end[k]; i++) {
				total += i;
			}
			String outputFormat = String.format("Total start %d end %d: %d",start[k],end[k],total);
			System.out.println(outputFormat);
		}
		
		
	}

}
