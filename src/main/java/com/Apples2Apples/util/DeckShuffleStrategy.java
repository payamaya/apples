package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;

import java.util.List;

@FunctionalInterface
public interface DeckShuffleStrategy {
    void shuffle(List<Card> deck);
}
