package Interview;



public abstract class Card {
	//protected double balance = 100;
	protected double balance;
	protected double interest;
	public Card(double interestPercent,double balance) {
		this.balance = balance;
		this.interest = calcInterest(interestPercent);
	}
	
	protected double calcInterest(double interestPercent) {
		return balance * (interestPercent/100);
	}

	public double getInterest() {
		return this.interest;
	}
	
	

}
