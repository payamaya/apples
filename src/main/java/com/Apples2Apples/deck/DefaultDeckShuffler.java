package com.Apples2Apples.deck;


import com.Apples2Apples.card.Card;

import java.util.Collections;
import java.util.List;

public class DefaultDeckShuffler implements DeckShuffleStrategy {
    @Override
    public void shuffle(List<Card> deck) {
        Collections.shuffle(deck);
    }
}