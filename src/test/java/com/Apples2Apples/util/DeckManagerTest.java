package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
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
            players.add(new PlayerTest("Player" + i));  // Mock player for testing
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
class PlayerTest implements Player {
    private String name;
    private List<Card> hand;
    private boolean canSeeCards;

    public PlayerTest(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canSeeCards() {
        return canSeeCards;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {
        this.canSeeCards = canSeeCards;
    }

    @Override
    public int getScore() {
        return 0;  // Implement if needed
    }

    @Override
    public void incrementScore() {
        // Implement if needed
    }

    @Override
    public boolean hasSubmitted(Card card) {
        return hand.contains(card);
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void setHand(List<Card> cards) {
        this.hand = cards;
    }

    @Override
    public void setJudge(boolean isJudge) {
        // Implement if needed
    }

    @Override
    public boolean isJudge() {
        return false; // Implement if needed
    }

    @Override
    public Card chooseRedAppleCard() {
        return null;  // Mock implementation for testing
    }

    @Override
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        return null;  // Mock implementation for testing
    }

    @Override
    public void removeCard(Card chosenCard) {
        hand.remove(chosenCard);
    }

    @Override
    public Card selectRedApple() {
        return null;  // Provide mock implementation if needed
    }

    @Override
    public void update(String message) {
        // Provide mock update method for observer pattern if needed
    }
}
