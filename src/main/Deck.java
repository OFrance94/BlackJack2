package main;


import java.util.ArrayList;
import java.util.Random;

public class Deck extends Game {
	public static ArrayList<Card> deck = new ArrayList<>();
	private static Random randomGenerator = new Random();

	public static void createDeck() {

		for (int i = 1; i <= 13; i++) {

			if (i == 1) {
				Card myCard = new Card("Hearts", "Ace");
				deck.add(myCard);
			} else if (i == 11) {
				Card myCard = new Card("Hearts", "Jack");
				deck.add(myCard);
			} else if (i == 12) {
				Card myCard = new Card("Hearts", "Queen");
				deck.add(myCard);

			} else if (i == 13) {
				Card myCard = new Card("Hearts", "King");
				deck.add(myCard);
			} else {
				Card myCard = new Card("Hearts", "" + i);
				deck.add(myCard);
			}
		}

		for (int i = 1; i <= 13; i++) {

			if (i == 1) {
				Card myCard = new Card("Spades", "Ace");
				deck.add(myCard);
			} else if (i == 11) {
				Card myCard = new Card("Spades", "Jack");
				deck.add(myCard);
			} else if (i == 12) {
				Card myCard = new Card("Spades", "Queen");
				deck.add(myCard);

			} else if (i == 13) {
				Card myCard = new Card("Spades", "King");
				deck.add(myCard);
			} else {
				Card myCard = new Card("Spades", "" + i);
				deck.add(myCard);
			}
		}
		for (int i = 1; i <= 13; i++) {

			if (i == 1) {
				Card myCard = new Card("Clubs", "Ace");
				deck.add(myCard);
			} else if (i == 11) {
				Card myCard = new Card("Clubs", "Jack");
				deck.add(myCard);
			} else if (i == 12) {
				Card myCard = new Card("Clubs", "Queen");
				deck.add(myCard);

			} else if (i == 13) {
				Card myCard = new Card("Clubs", "King");
				deck.add(myCard);
			} else {
				Card myCard = new Card("Clubs", "" + i);
				deck.add(myCard);
			}
		}
		for (int i = 1; i <= 13; i++) {

			if (i == 1) {
				Card myCard = new Card("Diamonds", "Ace");
				deck.add(myCard);
			} else if (i == 11) {
				Card myCard = new Card("Diamonds", "Jack");
				deck.add(myCard);
			} else if (i == 12) {
				Card myCard = new Card("Diamonds", "Queen");
				deck.add(myCard);

			} else if (i == 13) {
				Card myCard = new Card("Diamonds", "King");
				deck.add(myCard);
			} else {
				Card myCard = new Card("Diamonds", "" + i);
				deck.add(myCard);
			}
		}

	}

	public static int deckSize() {
		int deckSize = deck.size();
		return deckSize;
	}

	public static Card hit() {
		int index = randomGenerator.nextInt(deck.size());
		if (index < 0)
			throw new IllegalArgumentException("bound must be positive");
		else {

			Card card = deck.get(index);
			deck.remove(index);
			return card;
		}
	}


}
