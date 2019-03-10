import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
		System.out.println("Hello");
		
		char[] chars = {'a','b','a',' ','f'};
		
		System.out.println(countCharArray(chars));
		char[] duplicateChar = duplicateCharArray(chars);
		System.out.println(String.valueOf(removeWhiteSpace(chars)));
		
		System.out.println(duplicateChar);
		
		String word = "How are you";
		
		System.out.println(reverseWord(word));
	}
	
	
	public static Integer countCharArray(char[] charArray) {
		int count = 0;
		for(char c : charArray) {
			if(c == 'a') count ++;
		}
		
		return count;
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
	
	public static char[] duplicateCharArray(char[] charArray) {
		char[] tempCharArray = new char[charArray.length];
		for(int i = 0; i < charArray.length; i++) {
			tempCharArray[i] = charArray[i];
		}
		
		return tempCharArray;
		
	}
	
	public static String reverseWord(String word) {
		//char[] wordChar = new char[word.length()];
		int indexSpace = 0;
		String tempWord = "";
		
		//System.out.println(word.length());
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == ' ') {
				tempWord = word.substring(indexSpace,i) + " " + tempWord;
				indexSpace = i;
			}
		}
		tempWord = word.substring(indexSpace,word.length()) + tempWord;
		
		return tempWord.charAt(0) == ' ' ? String.valueOf(tempWord).substring(1) : String.valueOf(tempWord);
	}
	
}
