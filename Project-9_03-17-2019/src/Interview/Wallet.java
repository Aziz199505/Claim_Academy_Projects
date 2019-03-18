package Interview;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
	private List<Card> cards = new ArrayList<Card>();
	
	
	public Wallet() {
		
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
	
	
}
