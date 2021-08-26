package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static ArrayList<Card> playerHand = new ArrayList<>();
	static ArrayList<Card> dealerHand = new ArrayList<>();
	static Scanner playerInput = new Scanner(System.in);
	public static boolean playerBust = false;
	static boolean dealerBust = false;
	static String keepPlaying = "y";
	// static int money = 500; //use a loop to keep playing and change money amount

	public static void main(String[] args) {
		Deck.createDeck();

		startGame();
		// System.out.println("You currently have "+money + " pounds.);

		Player.playerHand();

		Dealer.dealerHand();

		playerTurn();

		dealerTurn();

		finalResult();

	}

	public static void startGame() {
		System.out.println("Welcome to BlackJack! Starting with " + Deck.deckSize()
				+ "The rules are simple, keep your hand to at max 21 in value! You start with two cards, ");
		System.out.println(
				"and can then choose to stick with them or draw another card. Score closer to 21 than the dealer and you win!");
		System.out.println("Jack, Queen and King are 10, and Aces can be either 1 or 11, your choice.");
		Player.addCard();
		Player.addCard();
		Dealer.addCard();
		Dealer.addCard();
	}

	public static void playerTurn() {
		System.out.println("Your cards equal " + Player.getTotal());
		System.out.println("Dealers cards equal " + Dealer.getTotal());
		while (Player.getTotal() <= 20) {
			System.out.println("Do you want to hit or stay?");
			String hOrS = playerInput.nextLine();
			if (hOrS.equals("hit")) {
				Player.playerTurn();
			} else if (hOrS.equals("stay")) {
				break;
			}

		}
		if (Player.getTotal() > 21) {
			playerBust = true;
			// money = money/2;
			// System.out.println("You now have " + money + " pounds.");
		} else if (Player.getTotal() == 21) {
			System.out.println("21! Well done!");
		} else if (Player.getTotal() < 21) {
			System.out.println("Okay, now for the dealer's turn.");
		}

	}

	public static void dealerTurn() {
		while (Dealer.getTotal() <= 16) {
			Dealer.dealerDraw();
			if (Dealer.getTotal() > 21) {
				dealerBust = true;
				break;
			}
		}
		System.out.println("Deakers cards now equal " + Dealer.getTotal());
	}

	public static void finalResult() {
		if ((playerBust == true) && !(dealerBust == true)) {
			System.out.println("Too bad, you went bust! Dealer wins!");
		} else if (!(playerBust == true) && (dealerBust == true)) {
			System.out.println("Dealer has gone bust, you win!");
		} else if (!(playerBust == true) && !(dealerBust == true)) {
			if (Player.getTotal() > Dealer.getTotal()) {
				System.out.println("Well done, you beat the dealer! You scored " + Player.getTotal()
						+ " and the Dealer scored " + Dealer.getTotal());
			} else if (Dealer.getTotal() > Player.getTotal()) {
				System.out.println("Unlucky, the dealer won! You scored " + Player.getTotal()
						+ " and the Dealer scored " + Dealer.getTotal());
				// money = money/2;
				// System.out.println("You now have " + money + " pounds.");
			}
		}
	}
}
