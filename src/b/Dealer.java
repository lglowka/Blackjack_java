package b;

public class Dealer extends Player{

	public Dealer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action(Deck deck, double bet) {
		this.handValue = 0;
		boolean play = true;
		int numOfLoops = 0;
		int v = 0;
		while(play) {
			if(showValue(v) == 21) {
				System.out.println("Dealer got 21!");
				play = false;
			} else if(showValue(v) < 17) {
				deck.checkDeck();
				draw(deck);
				showHand();
				System.out.println(showValue(v));
			} else if(showValue(v) > 21) {
				numOfLoops++;
				if(numOfLoops <= numOfA()) {
					v -= 10;
					System.out.println("Ace = 1");
					System.out.println(showValue(v));
				}else {
					System.out.println("Dealer bust");
					play = false;
				}
				
			} else {
				System.out.println("Dealer stay on " + showValue(v));
				play = false;
			}
		} this.handValue = showValue(v); 
	}
	@Override
	public void split(Deck deck) {
		System.out.println("Dealer can't split cards");
	}
	@Override
	public void doubleBet(double bet, Deck deck, int v) {
		System.out.println("Dealer can't double bet");
	}

}
