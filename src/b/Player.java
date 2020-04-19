package b;

import java.util.Scanner;
import java.util.Vector;

public class Player {
	
	private double bet;
	private int winnings = 0;
	private String name = new String();
	private Vector<Card> hand = new Vector<Card>();
	private Vector<Card> hand1 = new Vector<Card>();
	protected int handValue = 0;
	
	Scanner keybordInput = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
	}
	
	public Vector<Card> getHand1() {
		return this.hand1;
	}
	
	public Vector<Card> getHand() {
		return this.hand;
	}
	
	public void setHand(Card card) {
		this.hand.add(card);
	}
	
	public void setHand1() {
		this.hand1.remove(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void action(Deck deck, double bet) {
		this.handValue = 0;
		boolean play = true;
		int numOfLoops = 0;
		int v = 0;
		int ac = 0;
		String dec = new String();
		while(play) {
			if(showValue(v) == 21) {
				System.out.println("You got 21!");
				play = false;
			} else if(showValue(v) < 21 && ac == 0) {
				System.out.println("Dealer: Action on player\nType [h] to hit, [s] to stay,[d] to double");
				dec = keybordInput.nextLine();
				if(dec.toLowerCase().equals("h")) {
					ac++;
					deck.checkDeck();
					draw(deck);
					showHand();
					System.out.println(showValue(v));	
				} else if(dec.toLowerCase().equals("s")) {
					System.out.println("Player stay on " + showValue(v));
					play = false;
				} else if(dec.toLowerCase().equals("d")) {
					
					doubleBet(bet, deck, v);
					System.out.println("Bet = " + getBet());
					
					play = false;
				}
			} else if(showValue(v) < 21 && ac != 0) {
				System.out.println("Dealer: Action on player\nType [h] to hit, [s] to stay");
				dec = keybordInput.nextLine();
				if(dec.toLowerCase().equals("h")) {
					ac++;
					deck.checkDeck();
					draw(deck);
					showHand();
					System.out.println(showValue(v));	
				} else if(dec.toLowerCase().equals("s")) {
					System.out.println("Player stay on " + showValue(v));
					play = false;
				
				}
					
			} else if(showValue(v) > 21) {
				numOfLoops++;
				if(numOfLoops <= numOfA()) {
					v -= 10;
					System.out.println("Ace = 1");
					System.out.println(showValue(v));
				}else {
					System.out.println("Player bust");
					play = false;
				}
				
			}
		} this.handValue = showValue(v);
		
		
	}
	
	public void doubleBet(double bet, Deck deck, int v) {
		int numOfLoops = 0;
		this.winnings -= bet;
		this.setBet(bet + bet);
		deck.checkDeck();
		draw(deck);
		showHand();
		System.out.println(showValue(v));
		if(showValue(v) > 21) {
			numOfLoops++;
			if(numOfLoops <= numOfA()) {
				v -= 10;
				System.out.println("Ace = 1");
				System.out.println("Player stay on " + showValue(v));
					
				} else {
					System.out.println("Player bust!");
				}
				
	    } else {
	    	System.out.println("Player stay on " + showValue(v));
	    }
		this.handValue = showValue(v);
	}
	
	
	public boolean canSplit() {
		if(hand.get(0).getValue() == hand.get(1).getValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void split(Deck deck) {
		this.hand1.add(this.hand.remove(0));
		deck.checkDeck();
		draw(deck);
		showHand();
	}

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}
	
	public void modWinnings(double bet) {
		this.winnings += bet; 
	}
	
	public int getWinnings() {
		return winnings;
	}
	
	public int getHandValue() {
		return this.handValue;
	}
	
	public void setHandValue(int value) {
		this.handValue = value;
	}
	
	
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	
	public void showHand() {
		for(int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).getValue() + " of " + hand.get(i).getSuit());
	 }
	}
	
	public int showValue(int v) {
		for(int i = 0; i < hand.size(); i++) {
			v +=  hand.get(i).getWeight();			
	}
		return v;
	}
	
	public void discard() {
		hand.clear();
	}
	
	public int numOfA() {
		int num = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getValue() == 'A') {
				num++;
			}
		}
		return num;
	}

	
	public double winner(Dealer dealer, double bet) {
		double win;
		if(handValue <= 21 && dealer.getHandValue() <=21) {
			if(handValue > dealer.getHandValue()) {
				win = 2*bet;
				System.out.println("You won " + win);
			}else if(handValue == dealer.getHandValue()) {
				win = bet;
				System.out.println("Draw. You got back " + win);
			}else {
				win = 0;
				System.out.println("You lost");
			}
		}else if(handValue > 21 && dealer.getHandValue() > 21) {
			win = bet;
			System.out.println("Draw. You got back " + win);
		}else if(handValue > 21 && 21 >= dealer.getHandValue()) {
			win = 0;
			System.out.println("You lost");
		}else {
			win = 2*bet;
			System.out.println("You won " + win);
		}
		this.winnings += win;
		return win;
	}
	
	public void res() {
		if(winnings == 0) {
			System.out.println("You broke even");
		}else if(winnings > 0) {
			System.out.println("Profit " + winnings);
		}else {
			System.out.println("You lost " + winnings);
		}
	}

}
