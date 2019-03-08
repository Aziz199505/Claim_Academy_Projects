package Lap;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(greenTicket(1, 2, 3)) ;//  0
		System.out.println(greenTicket(2, 2, 2)); //  20
		System.out.println(greenTicket(1, 1, 2)); //  10
		
		System.out.println(countXX("abcxx"));
		System.out.println(countXX("xxx"));
		System.out.println(countXX("xxxx"));

	}
	
	public static boolean squirrelPlay(int temp,boolean isSummer) {
		if(isSummer) return ((temp >= 60) && (temp <= 100)) ? true : false;
		else return ((temp >= 60) && (temp <= 90)) ? true : false;
	}
	
	public static int greenTicket(int a,int b,int c) {
		if(a == b && b == c) {
			return 20;
		}else if(a != b && b !=c ) {
			return 0;
		}else {
			return 10;
		}
	}
	
	public static int countXX(String word) {
		int count = 0;
		
		for(char w : word.toCharArray()) {
			String letter = String.valueOf(w);
			if(letter.equals("x")) count ++;
			
		}
		if(count == 0) return 0;
		else return count -1;
		
		//return 0;
	}
	
	public static String stringTimes(String word, int count) {
		String tempWord = "";
		
		for(int i = 0 ; i < count; i ++) {
			tempWord += word;
		}
		
		return tempWord;
	}

}
