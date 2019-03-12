package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;




public class learn  {
	

	public static void main(String[] args) {
		
		String word = "aaaaaaaaaaaaaaaaabbbbcddddeeeeee" ;
		
		
		displayMostOccurLetter(word);
		
		 
		 
		String name1 = "India";
		String removeWord = "in";
		
		displayFilteredWord(name1,removeWord);
		
		
		
		String longOccur = "ABCCCCCBBA";
		
		displayFilterOccuringWords(longOccur);
		

		
		
	}
	
	
	//==================================DISPLAY========================//
	
	public static void displayMostOccurLetter(String word) {
		
		
		ArrayList<String> wordCount = convertArrayList(word);
		
		
		 Map<String, Long> counted = groupCount(wordCount);

		 
		 //System.out.println(counted);
		 List<Long> list = getMostOccurValuesSortedList(counted);

		 
		 //Retriveing most occur value
		 long mostCountedValue = list.get(list.size()-1);
		 
		 
		 //getKeyByValue(list.get(list.size()-1),counted);
		 
		 //Converting long to int in order to used for list index
		 int highestOccur = Math.toIntExact(mostCountedValue);
		
		 String formatHighOccur = String.format("Highest occurance for %s is %d", getKeyByValue(mostCountedValue,counted),highestOccur);
		 System.out.println(formatHighOccur);
	}
	
	
	public static void displayFilteredWord(String name1, String removeWord) {
		System.out.println(retrievedFilteredWord(name1,removeWord));
	}
	
	
	public static void displayFilterOccuringWords(String longOccur) {
		System.out.println(filterOccuringWords(longOccur));
	}
	//================================Methods========================================================//
	
	
	//========================================1st Assign================================//
	
	/*
	 * Sorting from least to most occur values in order to retrieve most occur
	 * values
	 */
	public static List<Long> getMostOccurValuesSortedList(Map<String, Long> counted) {
		List<Long> list = new ArrayList<Long>(counted.values());
		 
		 Collections.sort(list);
		 return list;
	}
	
	/* Converts java array to ArrayList in order to use for grouping */
	public static ArrayList<String> convertArrayList(String word) {
		ArrayList<String> wordCount = new ArrayList<>();	
		
		for(char w : word.toCharArray()) {
			wordCount.add(String.valueOf(w));
		}
		
		return wordCount;
	}
	
	/* Grouping same strings together which counts total number of same chars returns Map object*/
	public static Map<String, Long> groupCount(ArrayList<String> wordCount) {
		Map<String, Long> counted = wordCount.stream()
	            .collect(Collectors.groupingByConcurrent (Function.identity(), Collectors.counting()));
		
		return counted;
	}
	
	/*
	 * Getting key value which is one character with most value used by sorting
	 * value of most occur
	 * used to display word
	 */
	public static String getKeyByValue(Long l, Map<String, Long> counted) {
		
		for (String key : counted.keySet()) {
		    Long value = counted.get(key);
		    if(value == l) return key;
		    //System.out.println("Key = " + key + ", Value = " + value);
		}
		return "";
	}
	
	//========================================1st Assign================================//
	
	//========================================2nd Assign================================//

	/* check each removeWord inside word if it is replaces that word */
	public static String retrievedFilteredWord(String name1, String removeWord) {
		String temp = name1.toLowerCase();
		for(char r : removeWord.toCharArray()) {
				String f = String.valueOf(r);
				if(temp.contains(f)) {
					name1 = name1.replace(f.toLowerCase(), "");
					name1 = name1.replace(f.toUpperCase(), "");
				}
			}
		
		return name1;
	}
	

	
	//========================================2nd Assign================================//

	
	//========================================3rd Assign================================//

	
	public static String filterOccuringWords(String longOccur) {
		String storeLongOccur = longOccur;
		for(int i = 0; i < longOccur.length() ; i++) {
			try {
				if(longOccur.substring(i,i+1).equals(longOccur.substring(i+1,i+2))) {
					//System.out.println(String.valueOf(longOccur.charAt(i)));
					storeLongOccur = storeLongOccur.replace(String.valueOf(longOccur.charAt(i)),"");
				}
			}catch(Exception e) {
			}
		}
		
		return storeLongOccur;
		
	}
	
	//========================================3rd Assign================================//

	
}
