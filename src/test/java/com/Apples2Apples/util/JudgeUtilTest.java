package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.observer.GameObserver;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.BotPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeUtilTest {
    private List<Card> greenApplesDeck;
    private GameNotification gameNotification;
    private List<Player> players; // Add this to hold the list of players

    @BeforeEach
    void setUp() {
        greenApplesDeck = new ArrayList<>();
        greenApplesDeck.add(new GreenAppleCard("Sour"));
        greenApplesDeck.add(new GreenAppleCard("Fresh"));

        gameNotification = new GameNotification();

        // Initialize the list of players
        players = new ArrayList<>();
        players.add(new BotPlayer("JudgeBot", new ArrayList<>(), true));
        players.add(new BotPlayer("PlayerBot1", new ArrayList<>(), false));
        players.add(new BotPlayer("PlayerBot2", new ArrayList<>(), false));

        // Add the players as observers to GameNotification
        for (Player player : players) {
            gameNotification.addObserver((GameObserver) player);
        }
    }

    @Test
    void testDrawGreenApple() {
        Card drawnCard = JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification, players);
        assertNotNull(drawnCard);
        assertEquals("Sour", drawnCard.getValue()); // Verify the first card is drawn
        assertEquals(1, greenApplesDeck.size());    // Deck size should decrease by 1

        // Check if the notification was sent to all players
        assertTrue(gameNotification.getMessage().contains("won the green apple"));
    }

    @Test
    void testDrawGreenAppleEmptyDeck() {
        greenApplesDeck.clear(); // Clear the deck to simulate an empty deck
        assertThrows(CustomExceptions.JudgeUtilException.class, () ->
                JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification, players));
    }
}
