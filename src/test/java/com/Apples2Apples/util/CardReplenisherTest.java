package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.game.GameConfig;
import com.Apples2Apples.player.BotPlayer;
import com.Apples2Apples.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardReplenisherTest {

    private List<Player> players;
    private List<Card> redApplesDeck;
    private static final int HAND_SIZE_LIMIT = 7;
    private List<Card> cards;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        redApplesDeck = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            players.add(new BotPlayer("Player" + i, cards, false)); // Provide an empty list of cards
        }

        for (int i = 0; i < 28; i++) {
            redApplesDeck.add(new RedAppleCard("Card" + i));
        }

        GameConfig.setHandSizeLimit(HAND_SIZE_LIMIT);
    }


    @Test
    void testReplenishAllPlayers() {
        CardReplenisher.replenishAllPlayers(players, redApplesDeck, HAND_SIZE_LIMIT);

        for (Player player : players) {
            assertEquals(HAND_SIZE_LIMIT, player.getHand().size(), player.getName() + " should have " + HAND_SIZE_LIMIT + " cards.");
        }

        int expectedDeckSize = 28 - (4 * HAND_SIZE_LIMIT);
        assertEquals(expectedDeckSize, redApplesDeck.size(), "Red apples deck size should decrease accordingly.");

        Set<Card> allCardsInHands = new HashSet<>();
        for (Player player : players) {
            allCardsInHands.addAll(player.getHand());
        }

        assertEquals(4 * HAND_SIZE_LIMIT, allCardsInHands.size(), "All players should have unique cards without duplicates.");
    }
    @Test
    void testReplenishWithInsufficientCards() {
        // Setup the deck with fewer cards (e.g., 27 cards instead of the expected 28)
        redApplesDeck = new ArrayList<>();
        int availableCards = 27;  // Simulating a deck with fewer cards than needed
        for (int i = 0; i < availableCards; i++) {
            redApplesDeck.add(new RedAppleCard("Card" + i));
        }

        // Replenish the players with the available cards
        CardReplenisher.replenishAllPlayers(players, redApplesDeck, HAND_SIZE_LIMIT);

        // Calculate how many cards each player should get based on available cards
        int cardsPerPlayer = availableCards / players.size();  // Number of cards each player can get initially
        int remainingCards = availableCards % players.size();  // Remaining cards after even distribution

        // Ensure each player gets the correct number of cards
        for (int i = 0; i < players.size(); i++) {
            int expectedCards = cardsPerPlayer + (i < remainingCards ? 1 : 0); // Distribute remaining cards
            assertEquals(expectedCards, players.get(i).getHand().size(),
                    "Player" + i + " should have " + expectedCards + " cards.");
        }

        // Assert that the deck is empty after replenishment
        assertEquals(0, redApplesDeck.size(), "Red apples deck should be empty after replenishing all players.");
    }


}
