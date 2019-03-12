package newLearn;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(S.substring(3,7));
		//System.out.println(S.substring(1,6));
		
		
		String line = "this is 20.d65dd text";
		
		
		String pattern = "is";
		
		
		
		Matcher p = Pattern.compile(pattern).matcher(line);
		while(p.find()) {
			System.out.println(p.group());
		}
		
		
		
		/*
		 * List<String> allMatches = new ArrayList<String>(); Matcher m =
		 * Pattern.compile(pattern) .matcher(line); while (m.find()) {
		 * allMatches.add(m.group(2)); System.out.println(m.group()); }
		 */
		 //System.out.println(allMatches);
		 
		/*
		 * for(int i = 0; i < allMatches.size()/2; i ++) {
		 * System.out.println(allMatches.get(i) + " " + allMatches.get(allMatches.size()
		 * - 1 - i)); } ;
		 */
		// String tempWord = "";
		 
		 
		 
		 
		 
		 //System.out.println(balanced(allMatches));
		 
		
		/*
		 * String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		 * "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
		 * + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		 * 
		 * Pattern p = Pattern.compile(IPADDRESS_PATTERN); Matcher m =
		 * p.matcher("000.12.234.23.23"); boolean b = m.matches();
		 * 
		 * System.out.println(b);
		 */
		/*
		 * int[] number = {1,2,3,5}; int[] number2 = Arrays.copyOf(number,
		 * number.length+1);
		 * 
		 * 
		 * for(int n : number2) { System.out.println(n); } for(int n : number) {
		 * System.out.println(n); }
		 */
		
		/*
		 * StringTokenizer st = new StringTokenizer(s,"!,?._'@ ");
		 * System.out.println(st.countTokens()); while (st.hasMoreTokens()) {
		 * System.out.println(st.nextToken()); }
		 */
		/*
		 * String a = "anagramm"; String b = "marganaa";
		 * 
		 * char[] d = a.toLowerCase().toCharArray(); char[] c =
		 * b.toLowerCase().toCharArray();
		 * 
		 * List<Character> listA = new ArrayList<Character>(); List<Character> listB =
		 * new ArrayList<Character>();
		 * 
		 * for(char w : d) listA.add(w); for(char w : c) listB.add(w);
		 * 
		 * Collections.sort(listA); Collections.sort(listB);
		 * 
		 * System.out.println(listA); System.out.println(listB);
		 * 
		 * System.out.println(listA.equals(listB));
		 */
		
		
		
		
		
		
		
		
		/*
		 * SortedSet<String> set = new TreeSet<String>();
		 * 
		 * 
		 * 
		 * for(int i = 0; i < S.length() -k; i++) { set.add(S.substring(i,i+k)); }
		 * 
		 * System.out.println(set);
		 */
		
		
	    
	}
	
	
	
	
	
	
	
	

}
