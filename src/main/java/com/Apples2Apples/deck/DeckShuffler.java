package com.Apples2Apples.deck;

import com.Apples2Apples.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * Provides utility methods for shuffling card decks.
 * Uses the default shuffle algorithm provided by {@code Collections.shuffle()}.
 */
public class DeckShuffler {
    public static void shuffleDeck(List<Card> deck) {
        if (deck != null && deck.size() > 1) {
            Collections.shuffle(deck);  // Only shuffle if there are multiple elements
        }
    }
}
