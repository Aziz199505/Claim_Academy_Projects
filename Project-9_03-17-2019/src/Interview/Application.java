package Interview;

public class Application {
	public static void main(String args[]) {
		
		
		Card card1 = new Visa(10,100);
		Card card2 = new MC(5,100);
		Card card3 = new Discover(1,100);
		
		///////// 1 Question /////////////////
		
		/*
		Wallet w1 = new Wallet();
		
		w1.addCard(card1);
		w1.addCard(card2);
		w1.addCard(card3);
		
		
		Person p1 = new Person();
		p1.addWallet(w1);
		p1.calcTotalInterest();
		System.out.println(String.format("Total Interest %.2f", p1.getTotalInterest()));
		
		*/
		
		///////// 2 Question /////////////////
		
		/*
		Wallet w1 = new Wallet();
		Wallet w2 = new Wallet();
		
		w1.addCard(card1);
		w1.addCard(card3);
		
		w2.addCard(card2);
		
		
		Person p1 = new Person();
		p1.addWallet(w1);
		p1.addWallet(w2);
		
		p1.calcTotalInterest();
		System.out.println(String.format("Total Interest %.2f", p1.getTotalInterest()));
		*/
		
		///////// 2 Question /////////////////
		
		
		///////// 3 Question /////////////////

		/*
		Wallet w1p1 = new Wallet();
		Wallet w1p2 = new Wallet();

		
		w1p1.addCard(card1);
		w1p1.addCard(card2);
		w1p1.addCard(card3);
		
		w1p2.addCard(card1);
		w1p2.addCard(card2);
		
		
		Person p1 = new Person();
		p1.addWallet(w1p1);
		
		Person p2 = new Person();
		p2.addWallet(w1p2);
		
		p1.calcTotalInterest();
		p2.calcTotalInterest();
		
		
		System.out.println(String.format("Total Interest Person1 %.2f", p1.getTotalInterest()));
		System.out.println(String.format("Total Interest Person2 %.2f", p2.getTotalInterest()));

		*/

		
	}

}
