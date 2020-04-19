package b;

import java.util.Scanner;


public class App {
	public static void main(String [] args) {
		
		Deck deck = new Deck();
		Dealer dealer = new Dealer("Dealer");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Whats Your name?");
		String name = scanner.next();
		Player player = new Player(name);
		Hand hand = new Hand();
		String next;
		
		boolean running = true;
		
		while(running) {
			hand.dealHand(player, dealer, deck);
			System.out.println("Next hand? To stop type [n]");
			next = scanner.next();
			if(next.equals("n")) {
				running = false;
			}
			
		}
		player.res();	
		scanner.close();
	}
}
