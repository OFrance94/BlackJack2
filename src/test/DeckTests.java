package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Deck;
import main.Player;

public class DeckTests {

	Deck testDeck;

	@BeforeEach
	void setUp() {
		testDeck = new Deck();
		Deck.createDeck();
	}

	@AfterEach
	void deleteDeck() {
		Deck.removeAll();
	}
	@Test
	@DisplayName("Ensures the deck is created properly")
	void testDeck() {
		assertEquals(52, Deck.deckSize(), "The deck is not being created");


	}

	@Test
	@DisplayName("Taking card from deck should lower deck size")
	void testHitDeck() {
		Deck.hit();
		assertEquals(51, Deck.deckSize(), "The deck is not lowering in size");


	}

	@Test
	@DisplayName("Dealer and Player should start with 2 cards")
	void testHands() {

		Player.addCard();
		Player.addCard();

		assertEquals(2, Player.playerSize(), "The player doesn't have two cards");

	}



}
