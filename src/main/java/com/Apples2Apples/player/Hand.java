package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Hand represents a player's collection of cards.
 * It provides methods to manage the cards, including adding, removing, and checking if a card exists in the hand.
 */
public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int size() {
        return cards.size();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public void setCards(List<Card> cards) {
    }
}
