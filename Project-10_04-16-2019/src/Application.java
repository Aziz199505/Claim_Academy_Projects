
public class Application {

	public static void main(String args[]) {
		
		
		int a = 5;
		int b = 2;
		
		int min = a < b ? a : b;
		int max = a > b ? a : b;
		
		
		int sumOfEvenNum = 0;
		for(int i = min ; i <= max; i++) {
			
			if(i % 2 ==0) sumOfEvenNum += i;
			System.out.println(i);
		}
		
		System.out.println("Sum of the even number: " + sumOfEvenNum);
		
		
		int number = 15;
		String word = "";
		if(number % 3 == 0) word = "Fizz";
		if(number % 5 == 0) word = "Buzz";
		if((number % 3 == 0) && (number % 5 == 0)) word = "FizzBuzz";
		
		
		System.out.println(word);
		
		
		int index = 3;
		String tempWord = "";

		for(int i = 0 ; i < index +1; i++ ) {
			tempWord = "";
			for(int j = 0; j < i ; j++) {
				tempWord += "*";
			}	
			System.out.println(tempWord);
		}
		
		
	}
}
