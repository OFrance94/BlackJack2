package main;

public class Player extends Game {

	public static void playerHand() {
		for (Card c : Game.playerHand) {
			System.out.println("You have the " + c.getValue() + " of " + c.getSuit());
		}

		for (Card c : Game.playerHand) {
			if (c.getValue().equals("Ace")) {
				System.out.println("Do you want your ace to equal 1 or 11?");
				String aceChoice = playerInput.nextLine();
				c.setValue(aceChoice);
			}
		}

	}

	public static void addCard() {
		playerHand.add(Deck.hit());
	}

	public static void playerTurn() {
		Card draw = Deck.hit();
		playerHand.add(draw);
		System.out.println("You drew the " + draw.getValue() + " of " + draw.getSuit());
		for (Card c : Game.playerHand) {
			if (c.getValue().equals("Ace")) {
				System.out.println("Do you want your ace to equal 1 or 11?");
				String aceChoice = playerInput.nextLine();
				draw.setValue("" + aceChoice);
			}
		}

		System.out.println("Your cards now equal " + Player.getTotal());

	}

	public static int playerSize() {
		int playerSize = playerHand.size();
		return playerSize;
	}

	public static int getTotal() {
		int total = 0;
		for (Card c : Game.playerHand) {
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
