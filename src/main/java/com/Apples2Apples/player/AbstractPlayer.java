package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

public abstract class AbstractPlayer implements Player {
    protected final String name;
    protected final Hand hand;
    private int score;

    public AbstractPlayer(String name) {
        this.name = name;
        this.hand = new Hand();
        this.score = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void incrementScore() {
        score++;
    }

    @Override
    public List<Card> getHand() {
        return hand.getCards();
    }

    @Override
    public void setHand(List<Card> cards) {
        hand.setCards(cards);
    }

    @Override
    public void addCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public void removeCard(Card card) {
        hand.removeCard(card);
    }

    @Override
    public boolean hasSubmitted(Card card) {
        return getHand().contains(card);
    }

    @Override
    public abstract Card chooseRedAppleCard();

    public abstract Card selectFavoriteRedApple(List<Card> submissions);
}
