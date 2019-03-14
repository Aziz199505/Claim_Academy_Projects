package main;
import java.math.BigDecimal; 


public class main {

	public static void main(String[] args) {
		
		String[] s = {"9","-100","000.00","56.05","0.04"};
		java.util.ArrayList<BigDecimal> bd = new java.util.ArrayList<>();
        for(int i = 0; i < s.length;i++) {
            bd.add(new BigDecimal(s[i]));
        }

        java.util.Collections.sort(bd);
        String[] newStr = new String[s.length];
        for(int i = 0; i < s.length; i++) {
            newStr[i] = String.valueOf(bd.get(i));
            //System.out.println(bd.get(i));
        }
        s = newStr;	
        
        for(int i=0; i < s.length; i++) {
        	System.out.println(s[i]);
        }
	}
	
	

}


