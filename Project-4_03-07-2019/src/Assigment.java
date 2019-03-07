import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assigment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		/*
		 * 1. Write a program to read an input and determine if a string has all unique
		 * characters.
		 */
		
		 
		displayUniqueChars(sc);
		
		/*
		 * 2. Write a program to convert every even position to upper case and every odd
		 * position to lower case. eg input "Banana" output :"bAnAnA" or input "StLouis"
		 * output:"sTlOuIs"
		 */
		
		displayUpperLower(sc);
		
		
		/*
		 * 3. Write a program to reverse a word. eg input "Java" output "avaJ".
		 * 
		 */
		
		displayReverseWord(sc);
		
		/*
		 * 4. Write a program to remove the middle character of a string. eg input
		 * "stack" output:"stck", input "banana" output: "bana"
		 * 
		 */
		
		
		displayMiddleChar(sc);
		
		/*
		 * 5. Write a program to determine if a string is a palindrome. eg. refer deed
		 */
		
		
		
		displayPalindrome(sc);
		
		/*
		 * 6. Write a program to count all the vowels in a string. eg input"banana"
		 * output:3
		 */
		
		displayVowel(sc);
		
		
		
		
	}
	
	
	
	public static void displayUniqueChars(Scanner sc) {
		System.out.print("Enter string to check all unique characters: ");
		String uniqueString = sc.nextLine();
		
		System.out.println("Is unique? " + isUniqueChars(uniqueString));
	}
	
	public static void displayUpperLower(Scanner sc) {
		System.out.print("Enter word to convert upper or lower: ");
		String upperLower = sc.nextLine();
		
		System.out.println(toUpperLower(upperLower));
	}
	
	
	public static void displayReverseWord(Scanner sc) {
		System.out.print("Enter Word to reverse: ");
		String reverseWord = sc.nextLine();
		
		System.out.println(String.format("Reverse word for %s is %s",reverseWord,reverseWord(reverseWord)));
	}
	
	public static void displayMiddleChar(Scanner sc) {
		System.out.print("Enter word to see middle letter: ");
		String middleString = sc.nextLine();
		System.out.println(middleLetter(middleString));
	}
	
	public static void displayPalindrome(Scanner sc) {
		System.out.print("Enter string to check is palindrome: ");
		String palindrome = sc.nextLine();
		
		System.out.println(isPalindrome(palindrome));
	}
	
	public static void displayVowel(Scanner sc) {
		System.out.print("Enter Word to count vowels: ");
		String vowelsWord = sc.nextLine();
		
		System.out.println(totalVowels(vowelsWord));
	}
	
	
	//Checks if characters are unique
	public static boolean isUniqueChars(String uniqueString) {
		String uniqueChecker = "";	
				for(char c : uniqueString.toCharArray()) {
					if(uniqueChecker.contains(Character.toString(c))) {
						return false;
					};
					uniqueChecker += c;			
				}
				return true;
			}
	
	
	public static String toUpperLower(String upperLower) {
		String convertUpLow = "";
		for(int i = 0 ; i < upperLower.length(); i++) {
			if(i % 2 == 0) {
				convertUpLow += upperLower.substring(i,i+1).toUpperCase();
			} else {
				convertUpLow += upperLower.substring(i,i+1).toLowerCase();
			}
		}
		return convertUpLow;
	}
	
	
	public static String reverseWord(String reverseWord) {
		String wordRev = "";
		for(int i = reverseWord.length() ; i > 0 ; i--) {
			wordRev += reverseWord.substring(i-1,i);

		}
		
		return wordRev;
	}
	
	public static String middleLetter(String middleString) {
		String character = "";
		if(middleString.length() % 2 == 0) {
			character = "Sorry there is no middle in even word";
		}else {

			character = "Middle letter: " + middleString.substring( (int) Math.ceil(middleString.length()/2),(int) Math.round(middleString.length()/2)+1);
		}
		
		return character;
	}
	
	public static String isPalindrome(String palindrome ) {
		String reverse = reverseWord(palindrome);

		if(palindrome.equals(reverse)) {
			return "It is palindrome";
		}else {
			return "It is not palindrome";
		}
		
	}
	
	public static String totalVowels(String vowelsWord) {
		String vowels = "aeiou";
		
		vowelsWord = vowelsWord.toLowerCase();
		
		int totalVowels = 0;
		for(char letter : vowelsWord.toCharArray()) {
			if(vowels.contains(Character.toString(letter))) totalVowels +=1;
				
		}
		
		return "Total Vowel Count: " + totalVowels;
	}

}
