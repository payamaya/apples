package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;

import java.util.Collections;
import java.util.List;

public class DeckShuffler {
    public static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }
}
