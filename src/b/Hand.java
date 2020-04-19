package b;

import java.util.Scanner;

public class Hand {
	
	Scanner keyboardInput = new Scanner(System.in);
	
	
	public void blackjack(Player player, Dealer dealer, Deck deck, double b) {
		player.setHandValue(21);
		System.out.println("Blackjack");
		deck.checkDeck();
		dealer.draw(deck);
		dealer.showHand();
		if(dealer.showValue(0) != 21) {
			dealer.setHandValue(dealer.showValue(0));
			player.setBet(1.25*b);
		}
		player.winner(dealer, player.getBet());
		player.setBet(b);
		player.discard();
		dealer.discard();
	}
	
	public void dealCards(Player player, Dealer dealer, Deck deck) {
		deck.checkDeck();
		dealer.draw(deck);
		System.out.println("Dealer hand: ");
		dealer.showHand();
		deck.checkDeck();
		player.draw(deck);
		deck.checkDeck();
		player.draw(deck);
		System.out.println(player.getName() + "'s hand: ");
		player.showHand();
	}
	
	public void hand1(Player player, Dealer dealer, Deck deck, double b) {
		player.modWinnings(-b);
		deck.checkDeck();
		dealer.draw(deck);
		player.setHand(player.getHand1().get(0));
		player.setHand1();
		deck.checkDeck();
		player.draw(deck);
		player.showHand();
		// check if blackjack
		if(player.showValue(0) == 21) {
			blackjack(player, dealer, deck, b);
		} else {
			while(player.canSplit()) {
				System.out.println("To split type [s]");
				String dec = keyboardInput.next();
				if(dec.equals("s")) {
					player.split(deck);
				}else {
					player.showHand();
					break;
				}
			}
			if(player.showValue(0) == 21) {
				blackjack(player, dealer, deck, b);
			} else {
				player.action(deck, b);
				dealer.action(deck, 0);
				player.winner(dealer, player.getBet());
				player.setBet(b);
				player.discard();
				dealer.discard();
				
			}
		}
	}
	

	public void dealHand(Player player, Dealer dealer, Deck deck) {
		// set bet
		int b;
		System.out.println("Dealer: New hand, place Your bet: ");
		
		while (!keyboardInput.hasNextInt()) {
			String string = keyboardInput.next();
			System.out.println("Oops!  That was no valid bet.  Try again.");
			}
		b = keyboardInput.nextInt();
		player.setBet(b);
		player.modWinnings(-b);
		// check deck and deal hand
		dealCards(player, dealer, deck);
		// check if blackjack
		if(player.showValue(0) == 21) {
			blackjack(player, dealer, deck, b);
		} else {
			// check if can split
			while(player.canSplit()) {
				System.out.println("To split type [s]");
				String dec = keyboardInput.next();
				if(dec.equals("s")) {
					player.split(deck);
				}else {
					player.showHand();
					break;
				}
			}
			if(player.showValue(0) == 21) {
				blackjack(player, dealer, deck, b);
			} else {
				player.action(deck, b);
				dealer.action(deck, 0);
				player.winner(dealer, player.getBet());
				player.setBet(b);
				player.discard();
				dealer.discard();
				
			}
			// go through hand1 (cards from split decision)
			while(!player.getHand1().isEmpty()) {
				hand1(player, dealer, deck, b);
			}	
		}
	}
}
