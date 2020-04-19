package b;

import java.util.Vector;

public class Deck {
	
	private Vector<Card> cards = new Vector<Card>();

	
	private int numOfCards = 52;
	private char [] suit = {'S', 'H', 'D', 'C'};
	private char [] value = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};
	
	
	public void buildDeck() {
		int numOfDecks = 1;
		int w = 0;
		for(int i = 0; i < numOfDecks; i++) {
			for(int s = 0; s < suit.length; s++) {
				for(int v = 0; v < value.length; v++) {
					if(value[v] == 'A') {
						w = 11;
					} else if(value[v] == 'K' || value[v] == 'Q' || value[v] == 'J' || value[v] == 'T') {
						w = 10;
					} else if(value[v] == '9') {
						w = 9;
					} else if(value[v] == '8') {
						w = 8;
					} else if(value[v] == '7') {
						w = 7;
					} else if(value[v] == '6') {
						w = 6;
					} else if(value[v] == '5') {
						w = 5;
					} else if(value[v] == '4') {
						w = 4;
					} else if(value[v] == '3') {
						w = 3;
					} else if(value[v] == '2') {
						w = 2;
					}
					Card c = new Card(suit[s], value[v], w);
					cards.add(c);
				}
			}
		}
	}
	public void showDeck() {
		for(int i = 0; i < cards.size(); i++) {
			System.out.println(cards.get(i).getValue() + " of " + cards.get(i).getSuit());
		}
	}
	
	public void shuffle() {
		for(int i = cards.size() - 1; i >= 0; i--) {
			int r =  (int) (Math.random()*numOfCards);
			Card tempCard = cards.get(i);
			cards.set(i, cards.get(r));
			cards.set(r, tempCard);
			
		}
	}
	
	public Card draw() {
		Card drawCard = this.cards.remove(cards.size()-1);
		return drawCard;
		
		
	}
	
	public void checkDeck() {
		if(cards.isEmpty()) {
			buildDeck();
			shuffle();
		}
	}


}
