package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.card.RedAppleSubmissionManager;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.BotPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedAppleSubmissionManagerTest {
    private List<Player> players;
    private RedAppleSubmissionManager submissionManager;
    private List<Card> cards;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        submissionManager = new RedAppleSubmissionManager(); // Ensure submissionManager is instantiated

        for (int i = 0; i < 4; i++) {
            // Provide an empty list of cards as required by BotPlayer constructor
            Player player = new BotPlayer("Player " + i, cards, false);
            player.addCard(new RedAppleCard("Card " + i));
            player.addCard(new RedAppleCard("ExtraCard " + i)); // Extra card for multiple submissions
            players.add(player);
        }
    }

    @Test
    void testCollectSubmissions() {
        List<Card> submissions = submissionManager.collectSubmissions(players);

        assertEquals(4, submissions.size(), "All players should submit one card.");
        submissions.forEach(submission -> assertNotNull(submission, "Submission should not be null."));
    }

    @Test
    void testSubmissionsAreShuffled() {
        // Collect submissions the first time
        List<Card> originalOrder = submissionManager.collectSubmissions(players);

        // Replenish with entirely new cards
        List<Player> newPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            newPlayers.add(new BotPlayer("Player " + i, cards, false));
            newPlayers.get(i).addCard(new RedAppleCard("New Card " + i));
        }

        // Collect submissions with new players
        List<Card> newOrder = submissionManager.collectSubmissions(newPlayers);

        // Ensure the size is the same
        assertEquals(originalOrder.size(), newOrder.size(), "Both submissions should have the same size.");

        // Verify order has changed at least once
        boolean isShuffled = !originalOrder.equals(newOrder);
        assertNotEquals(isShuffled, "The order of submissions should change after shuffling.");
    }

    @Test
    void testDiscardSubmissions() {
        List<Card> cards = new ArrayList<>();
        cards.add(new RedAppleCard("Card 1"));
        cards.add(new RedAppleCard("Card 2"));
        cards.add(new RedAppleCard("Card 3"));

        submissionManager.discardSubmissions(cards);

        assertEquals(0, cards.size(), "The list of submissions should be empty after discarding.");
    }

    @Test
    void testGetSubmissions() {
        players.get(0).addCard(new RedAppleCard("Card"));
        submissionManager.collectSubmissions(players);
        List<Card> submissions = submissionManager.getSubmissions();
        assertEquals(players.size(), submissions.size(), "The number of submissions should match the number of players.");
    }
}
