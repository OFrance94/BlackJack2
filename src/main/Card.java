package main;

public class Card extends Deck {
	String suit;
	String value;

	public Card(String cardSuit, String cardNo) {
		suit = cardSuit;
		value = cardNo;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}