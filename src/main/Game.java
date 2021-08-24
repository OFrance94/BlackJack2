package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	static ArrayList<Card> playerHand = new ArrayList<>();
	static ArrayList<Card> dealerHand = new ArrayList<>();
	static Scanner playerInput = new Scanner(System.in);
	static boolean playerBust = false;
	static boolean dealerBust = false;
	static String keepPlaying = "y";
	//static int money = 500; //use a loop to keep playing and change money amount

	public static void main(String[] args) {
		while(keepPlaying.equals("y")) {
		Deck.createDeck();

		System.out.println(
				"Welcome to BlackJack! Starting with "+ Deck.deckSize() + "The rules are simple, keep your hand to at max 21 in value! You start with two cards, ");
		System.out.println(
				"and can then choose to stick with them or draw another card. Score closer to 21 than the dealer and you win!");
		System.out.println("Jack, Queen and King are 10, and Aces can be either 1 or 11, your choice.");
		//System.out.println("You currently have "+money + " pounds.);

		Player.addCard();
		Player.addCard();
		Dealer.addCard();
		Dealer.addCard();

		Player.playerHand();

		Dealer.dealerHand();

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
			System.out.println("Bust! You lose.");
			playerBust = true;
			//money = money/2;
			//System.out.println("You now have " + money + " pounds.");
		} else if (Player.getTotal() == 21) {
			System.out.println("21! Well done!");
		} else if (Player.getTotal() < 21) {
			System.out.println("Okay, now for the dealer's turn.");
		}

		while (Dealer.getTotal() <= 16) {
			Dealer.dealerTurn();
			if (Dealer.getTotal() > 21) {
				System.out.println("Dealer has gone bust!");
				dealerBust = true;
			}
		}

		if (!playerBust && !dealerBust) {
			if (Player.getTotal() > Dealer.getTotal()) {
				System.out.println("Well done, you beat the dealer! You scored " + Player.getTotal()
						+ " and the Dealer scored " + Dealer.getTotal());
			} else if (Dealer.getTotal() > Player.getTotal()) {
				System.out.println("Unlucky, the dealer won! You scored " + Player.getTotal()
						+ " and the Dealer scored " + Dealer.getTotal());
				//money = money/2;
				//System.out.println("You now have " + money + " pounds.");
			}
		}

	}
	}

}
