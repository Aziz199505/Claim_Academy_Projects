package Interview;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private double balance;
	private double totalInterest = 0;
	private List<Wallet> wallets = new ArrayList<Wallet>();
	public Person() {
		
	}
	
	public void addWallet(Wallet wallet) {
		wallets.add(wallet);
	}
	
	
	public void calcTotalInterest() {
		for(Wallet w : wallets) {
			for(Card c : w.getCards()) {
				totalInterest += c.getInterest();
			}
		}
	}
	
	public double getTotalInterest() {
		return this.totalInterest;
	}
	
}
