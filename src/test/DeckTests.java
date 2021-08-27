package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Deck;
import main.Game;
import main.Player;
import main.Dealer;

public class DeckTests {

	Deck testDeck;

	@BeforeEach
	void setUp() {
		testDeck = new Deck();
		Deck.createDeck();
	}

	@AfterEach
	void deleteDeck() {
		Deck.deck.clear();
		Game.dealerHand.clear();
		Game.playerHand.clear();
	}

	@Test
	@DisplayName("Ensures the deck is created properly")
	void testDeck() {
		assertEquals(52, Deck.deckSize(), "The deck is not being created");

	}
	
	@Test
	@DisplayName("Check if dealer going bust is checked")
	void testDealerBust() {
		Dealer.addCard();
		Dealer.addCard();
		Dealer.addCard();
		Dealer.addCard();
		Dealer.addCard();
		Dealer.dealerTurn();
		Dealer.isDealerBust();
		
		assertEquals(true, Dealer.isDealerBust(), "Dealer is not getting checked as bust");
		
		
	}
	
	@Test
	@DisplayName("Check if Player going bust is checked")
	void testPlayerBust() {
		Player.addCard();
		Player.addCard();
		Player.addCard();
		Player.addCard();
		Player.addCard();
		Player.playerTurn();
		Player.isPlayerBust();
		
		assertEquals(true, Player.isPlayerBust(), "Player is not getting checked as bust");
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
		Dealer.addCard();
		Dealer.addCard();
		Player.addCard();
		Player.addCard();

		assertAll("Should give both player and dealer 2 cards", () -> assertEquals(2, Player.playerSize()), () -> assertEquals(2, Dealer.dealerSize()));

	}
	
	@Test
	@DisplayName("Check if starting game gives player and dealer 2 cards")
	void testStart(){
		Game.startGame();
		
		assertAll("Should give both player and dealer 2 cards", () -> assertEquals(2, Player.playerSize()), () -> assertEquals(2, Dealer.dealerSize()));
		
	}
	
	@Test
	@DisplayName("Check if dealer is drawing cards correctly")
	void testDealerDraw() {
		Dealer.addCard();
		Dealer.addCard();
		int dealerHand = Dealer.dealerHand.size();
		
		Dealer.dealerDraw();
		
		assertEquals(dealerHand+1,Dealer.dealerHand.size(),"The dealer is not drawing a card correctly");
		
		
		
	}
	
	


}
