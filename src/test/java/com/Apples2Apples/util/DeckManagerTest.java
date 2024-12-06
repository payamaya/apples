package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.player.Hand;
import com.Apples2Apples.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DeckManagerTest {
    private List<Player> players;
    private List<Card> redApplesDeck;
    private DeckManager deckManager;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();

        // Use a mock Player subclass
        for (int i = 0; i < 4; i++) {
            players.add(new PlayerTest("Player" + i, new Hand()));  // Mock player for testing
        }

        redApplesDeck = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            redApplesDeck.add(new RedAppleCard("Card" + i));  // Use RedAppleCard for the test
        }
        deckManager = new DeckManager();
    }
    @Test
    void testDealCards() {
        // Use dealCards method to assign cards to players
        deckManager.dealCards(players, redApplesDeck, 7);

        for (Player player : players) {
            assertEquals(7, player.getHand().size(), player.getName() + " should have 7 cards.");
        }
        assertEquals(30 - (4 * 7), redApplesDeck.size(), "Remaining deck size should be correct.");
    }
}
// Mock Player class for testing purposes
 class PlayerTest extends Player {
    public PlayerTest(String name, Hand hand) {
        super(name);
    }

    @Override
    public Card chooseCard() {
        return null;
    }

    @Override
    public Card chooseRedAppleCard() {
        return null;
    }

    @Override
    public void removeCard(Card chosenCard) {
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> redAppleSubmissions) {
        return null;
    }


    public boolean hasSubmitted(Card favoriteRedApple) {
        return false;
    }

    @Override
    public Card selectRedApple() {
        return null;  // Provide a mock implementation, as it’s required
    }
     public void update(String message) {

     }
}