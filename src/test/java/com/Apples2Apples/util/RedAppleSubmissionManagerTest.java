package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.BotPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedAppleSubmissionManagerTest {
    private List<Player> players;
    private RedAppleSubmissionManager submissionManager;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        submissionManager = new RedAppleSubmissionManager();

        for (int i = 0; i < 4; i++) {
            Player player = new BotPlayer("Player " + i, false);
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
        System.out.println("Original Order: " + originalOrder);

        // Replenish cards with unique "NewCard" for each player and re-collect submissions
        players.forEach(player -> player.addCard(new RedAppleCard("NewCard " + player.getName())));  // Ensure distinct cards
        List<Card> newOrder = submissionManager.collectSubmissions(players);
        System.out.println("New Shuffled Order: " + newOrder);

        // Ensure the size is the same
        assertEquals(originalOrder.size(), newOrder.size(), "Both submissions should have the same size.");
        // Ensure the order is different
        assertFalse(originalOrder.get(0).equals(newOrder.get(0)), "First card should be different after shuffling");
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
        assertEquals(players.size() - 2, submissions.size());
    }
}
