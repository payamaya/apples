package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player implements Observer {

    protected String name;
    protected List<Card> hand;
    protected int score;
    private boolean isJudge; // Flag to indicate if this player is the judge

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();  // Initialize hand to an empty list
        this.score = 0;
        this.isJudge = false;
    }

    public Player(int playerID, List<Card> hand) {
        this.name = "Player " + playerID;  // Set a default name (you can customize this)
        this.hand = (hand != null) ? hand : new ArrayList<>();  // Ensure hand is initialized
        this.score = 0;
        this.isJudge = false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = (hand != null) ? hand : new ArrayList<>();  // Ensure hand is not null
    }

    public void setJudge(boolean judge) {
        this.isJudge = judge;
    }

    // Helper methods
    public boolean isJudge() {
        return isJudge;
    }

    public void addGreenApple() {
        this.score++;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    // Players choose a red apple card to play
    public Card chooseRedAppleCard() {
        // Simulate choosing a random card from the hand
        Random random = new Random();
        return hand.remove(random.nextInt(hand.size()));
    }

    // Judge selects a favorite red apple card
    public Card selectFavoriteRedApple(List<Card> submissions) {
        // Simulate judge picking a random favorite red apple
        Random random = new Random();
        return submissions.get(random.nextInt(submissions.size()));
    }

    // Check if a player submitted a specific card
    public boolean hasSubmitted(Card card) {
        return !hand.contains(card);
    }

    // Observer update method
    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }

    public abstract Card selectRedApple();
}
