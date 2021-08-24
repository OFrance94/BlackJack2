package main;

public class Dealer extends Game {

	public static void dealerHand() {
		for (Card c : Game.dealerHand) {
			System.out.println("Dealer has the " + c.getValue() + " of " + c.getSuit());
		}
	}

	public static void addCard() {
		dealerHand.add(Deck.hit());
	}

	public static void dealerTurn() {
		Card draw = Deck.hit();
		dealerHand.add(draw);
		System.out.println("Dealer drew the " + draw.getValue() + " of " + draw.getSuit());
		for (Card c : Game.dealerHand) {
			if (c.getValue().equals("Ace")) {
				if (getTotal() <= 10) {
					draw.setValue("11");
				} else if (getTotal() > 10) {
					draw.setValue("1");
				}

			}
		}

		System.out.println("Deakers cards now equal " + getTotal());
	}

	public static int dealerSize() {
		int dealerSize = dealerHand.size();
		return dealerSize;
	}

	public static int getTotal() {
		int total = 0;
		for (Card c : Game.dealerHand) {
			if (c.getValue().equals("Jack")) {
				total = total + 10;
			} else if (c.getValue().equals("Queen")) {
				total = total + 10;
			} else if (c.getValue().equals("King")) {
				total = total + 10;
			} else
				total = total + Integer.parseInt(c.getValue());
		}
		return total;

	}

}
