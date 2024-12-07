package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.deck.DeckShuffler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckShufflerTest {

    @Test
    void testShuffleDeckChangesOrder() {
        List<Card> deck = new ArrayList<>(Arrays.asList(
                new RedAppleCard("Courageous"),
                new RedAppleCard("Funny"),
                new RedAppleCard("Brave")
        ));

        List<Card> originalDeck = new ArrayList<>(deck);

        DeckShuffler.shuffleDeck(deck);

        // Check if at least one element has moved to a different position
        boolean isDifferentOrder = false;
        for (int i = 0; i < deck.size(); i++) {
            if (!deck.get(i).equals(originalDeck.get(i))) {
                isDifferentOrder = true;
                break;
            }
        }

        assertTrue(isDifferentOrder, "Deck order should be different after shuffle.");
    }

    @Test
    void testMultipleShufflesProduceDifferentOrders() {
        List<Card> deck = new ArrayList<>(Arrays.asList(
                new RedAppleCard("Courageous"),
                new RedAppleCard("Funny"),
                new RedAppleCard("Brave"),
                new RedAppleCard("Bold"),
                new RedAppleCard("Wise")
        ));

        List<String> firstShuffleOrder = new ArrayList<>();
        List<String> secondShuffleOrder = new ArrayList<>();

        // Shuffle and record order
        DeckShuffler.shuffleDeck(deck);
        for (Card card : deck) {
            firstShuffleOrder.add(card.getValue());
        }

        // Make sure second shuffle is different
        boolean isDifferentOrder = false;
        for (int attempt = 0; attempt < 5; attempt++) {  // Allow a few attempts to get a different order
            DeckShuffler.shuffleDeck(deck);
            secondShuffleOrder.clear();
            for (Card card : deck) {
                secondShuffleOrder.add(card.getValue());
            }

            // Check if the orders are different
            if (!firstShuffleOrder.equals(secondShuffleOrder)) {
                isDifferentOrder = true;
                break;
            }
        }

        // Ensure that the size of the deck is consistent
        assertEquals(firstShuffleOrder.size(), secondShuffleOrder.size(), "Deck size should remain the same after shuffle.");

        // Ensure the two orders are not identical after several attempts
        assertTrue(isDifferentOrder, "Different shuffles should produce different orders.");
    }



    @Test
    void testShuffleEmptyDeck() {
        List<Card> emptyDeck = new ArrayList<>();
        DeckShuffler.shuffleDeck(emptyDeck);

        assertTrue(emptyDeck.isEmpty(), "Empty deck should remain empty after shuffle.");
    }

    @Test
    void testShuffleSingleElementDeck() {
        List<Card> singleDeck = new ArrayList<>(List.of(new RedAppleCard("Courageous")));
        DeckShuffler.shuffleDeck(singleDeck);

        assertEquals(1, singleDeck.size(), "Single-element deck should still have one element.");
        assertEquals("Courageous", singleDeck.get(0).getValue(), "Single-element deck should remain unchanged.");
    }
}
