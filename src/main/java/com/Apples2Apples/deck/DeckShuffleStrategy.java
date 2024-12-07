package com.Apples2Apples.deck;

import com.Apples2Apples.card.Card;

import java.util.List;

/**
 * Defines a functional interface for customizing deck shuffle algorithms.
 * Enables flexibility in how card decks are randomized.
 */
@FunctionalInterface
public interface DeckShuffleStrategy {
    void shuffle(List<Card> deck);
}
