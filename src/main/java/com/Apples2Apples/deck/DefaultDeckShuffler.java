package com.Apples2Apples.deck;

import com.Apples2Apples.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * Implements the default shuffle strategy for card decks.
 * Uses {@code Collections.shuffle()} to randomize the order of cards.
 */
public class DefaultDeckShuffler implements DeckShuffleStrategy {
    @Override
    public void shuffle(List<Card> deck) {
        Collections.shuffle(deck);
    }
}