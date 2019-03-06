package MethodLab;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
public class MethodLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int n1 = input.nextInt();
		
		System.out.print("Enter second number: ");
		int n2 = input.nextInt();
		
		System.out.print("Enter third number: ");
		int n3 = input.nextInt();
		
		
		String maxFormat = String.format("Max number is %d", max3(n1,n2,n3));
		String minFormat = String.format("Min number is %d", min3(n1,n2,n3));
		String medFormat = String.format("Median number is %d", median3(n1,n2,n3));

		
		System.out.println(maxFormat); 
		System.out.println(minFormat);
		System.out.println(minFormat);
		 
		
		System.out.print("Enter third number: ");
		boolean bool = input.nextBoolean();
		
		
		//String xorFormat = String.format("Xor %b", xor(bool));

		
		
		System.out.println(isPrime(7));


	}
	
	public static int max3(int n1,int n2, int n3) {
		int max = n1;
		if(max < n2) max = n2;
		if(max < n3) max = n3;
		return max;
		
	}
	
	public static int min3(int n1,int n2, int n3) {
		int min = n1;
		if(min > n2) min = n2;
		if(min > n3) min = n3;
		return min;
		
	}
	
	public static int median3(int n1,int n2, int n3) {
		int mid = n1;
		
		int max = max3(n1,n2,n3);
		int min = min3(n1,n2,n3);
		
		if((max == n1 && min == n2) || (max == n2 && min == n1)) mid = n3;
		if((max == n1 && min == n3) || (max == n3 && min == n1)) mid = n2;

		
		
		return mid;
	
	}
	
	public static boolean xor(boolean b1, boolean b2) {
		if((b1 || b2) && !(b1 && b2)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean isFactor(int k, int n) {
		if(n % k == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPerfect(int n) {
		int sum = 0;
		
		for(int i = 1; i < n; i++) {
			if(isFactor(i,n)) {
				sum += i;
				System.out.println(i);
			}
		}
		
		if(n == 1) {
			return false;
		}
		
		if(sum == n) return true;
		else return false;
		
	}
	
	
	public static boolean isPrime(int n) {
		boolean prime = true;
		
		for(int i = 2; i < n; i++) {
			if(isFactor(i,n)) {
				prime = false;
			}
		}
		
		
		return prime;
	}
	
	
	
	
	
	

}
