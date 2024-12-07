package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

public interface Playable {
    Card chooseRedAppleCard();
    void addCard(Card card);
    void removeCard(Card card);
    boolean hasSubmitted(Card card);
}