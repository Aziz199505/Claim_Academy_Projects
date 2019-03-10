import java.util.Scanner;

public class MondayAssigment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.print("How many numbers you would like to average: ");
		//int totalNumber = sc.nextInt();
		
		//System.out.println(String.format("Average for %d numbers is %.2f", totalNumber,getAverage(totalNumber,sc)));
		
		int[] arrNumber = {1,3,4,6,4,1,5};
		
		
		System.out.println(sumArr(arrNumber));
		System.out.println(largestElinArr(arrNumber));
		
		System.out.println(removeCharFromStr("Averange",'a'));
		
		char[] listChar = {'a',' ','d',' ',' ','c'};
		
		System.out.println(removeWhiteSpace(listChar));
		
		System.out.println(removeDuplicateCharFromStr("aaabbbdddcccc"));
		
		System.out.println(countVowelsAndconsonants("Java"));
		
		System.out.println(nonrepeatAndRepeating("morning"));

	}
	
	public static double getAverage(int totalNumber,Scanner sc) {
		double totalCount = 0.0;
		for(int i = 0; i < totalNumber; i++) {
			System.out.print("Please enter number " + i+1 + ":");
			double number = sc.nextDouble();
			totalCount += number;
		}
		
		return totalCount/totalNumber;
	}
	
	public static int sumArr(int[] arr) {
		int total = 0;
		for(int i = 0; i < arr.length;i++) {
			total += arr[i];
		}
		
		return total;
	}
	
	public static int largestElinArr(int[] arr) {
		int largest = 0;
		for(int i = 0; i < arr.length; i++) {
			if(largest < arr[i]) largest = arr[i];
		}
		
		return largest;
	}
	
	public static String removeCharFromStr(String str,char c) {
		String tempWord = "";
		String wordCheck = str.toLowerCase();
		for(int i = 0 ; i < str.length() ; i++) {
			if(!(String.valueOf(str.charAt(i)).toLowerCase().equals(String.valueOf(c)))) {
				tempWord += str.charAt(i);
			}
		}
		
		return tempWord;
		
	}
	
	
	public static String removeDuplicateCharFromStr(String str) {
		char[] charChecker = new char[str.length()];
		boolean notThere = true;
		int count = 0;
		for(int i = 0 ; i < str.length(); i++) {
			notThere = true;
			if(charChecker[count] != str.charAt(i)) {
				for(int j = 0 ; j < str.length(); j++) {
					if(str.charAt(i) == charChecker[j]) notThere = false; 
				}
			}
			
			if(notThere) {
				charChecker[count] = str.charAt(i);
				count++;
			}
		}
		
		return String.valueOf(charChecker);
		
	}
	
	public static char[] removeWhiteSpace(char[] charArray) {
		//char[] tempCharArray = new char[charArray.length];
		char[] tempChar = new char[charArray.length];
		int counter = 0;
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] != ' ') {
				tempChar[counter] = charArray[i];
				counter++;
			}
		}
		
		//System.out.println(tempChar);
		return tempChar;
	}
	
	public static String countVowelsAndconsonants(String word) {
		char[] vowels = {'a','e','i','o','u'};
		char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'y', 'z'};
		int countVowels = 0;
		int countCons = 0;
		
		word = word.toLowerCase();
		for(int i = 0; i < word.length();i++) {
			if(word.charAt(i) != ' ') {
				for(int v =0; v < vowels.length; v++ ) {
					if(word.charAt(i) == vowels[v]) countVowels ++;
				}
				for(int c=0; c < consonant.length; c++) {
					if(word.charAt(i) == consonant[c]) countCons ++;
				}
			}
		}
		
		return String.format("%d vowels and %d consonants", countVowels,countCons);
	}
	
	public static String nonrepeatAndRepeating(String word) {
		String nonRepeat = "";
		String repeat = "";
		String uniqueWord = removeDuplicateCharFromStr(word);		
		for(int j = 0; j < uniqueWord.length(); j++) {
				int count = 0;
				for(int i =0; i < word.length(); i ++) {
					if(uniqueWord.charAt(j) == word.charAt(i)) {
						count ++;
					}
				}
				if(count == 1) {
					nonRepeat += uniqueWord.charAt(j);
				} else {
					for(int k = 0; k < count; k++) {
						repeat += uniqueWord.charAt(j);
				}
				}
			}
		return nonRepeat + repeat;
		
	}
	
	

}
