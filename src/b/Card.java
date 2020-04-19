package b;

public class Card {
	
	private char suit;
	private char value;
	private int weight;
	
	
	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Card(char s, char v, int w) {
		this.suit = s;
		this.value = v;
		this.weight = w;
		
	}
	
	public void showCard() {
		System.out.println(this.value + " of " + this.suit);
	}

}
