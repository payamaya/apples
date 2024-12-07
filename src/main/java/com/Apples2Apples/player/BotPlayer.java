package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.Observer;

import java.util.List;
import java.util.Random;

public class BotPlayer extends AbstractPlayer implements Judge, Observer {
    private boolean isJudge;

    public BotPlayer(String name, boolean isJudge) {
        super(name);
        this.isJudge = isJudge;
    }

    @Override
    public Card chooseRedAppleCard() {
        // Bot selects a random card from the hand
        return getRandomCard(getHand());  // Using getHand() to access the player's hand
    }

    @Override
    public boolean canSeeCards() {
        return false;  // Bots can't see others' cards
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {
        // No implementation needed for the bot
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        return getRandomCard(submissions); // Bot selects a random card from the submissions
    }

    @Override
    public Card selectRedApple() {
        return null;  // Bot doesn't participate in selecting the red apple
    }

    @Override
    public void update(String message) {
        // Optionally, log the update or handle it as needed
    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
    }

    @Override
    public boolean isJudge() {
        return isJudge;
    }

    // Utility method for selecting a random card
    private Card getRandomCard(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }
}

//public class BotPlayer extends AbstractPlayer implements Judgeable, Observer {
//    private boolean isJudge;
//
//    public BotPlayer(String name, boolean isJudge) {
//        super(name);
//        this.isJudge = isJudge;
//    }
//
//    @Override
//    public Card chooseRedAppleCard() {
//        return getRandomCard(hand.getCards());
//    }
//
//    @Override
//    public boolean canSeeCards() {
//        return false;
//    }
//
//    @Override
//    public void setCanSeeCards(boolean canSeeCards) {
//
//    }
//
//    @Override
//    public Card selectRedApple() {
//        return null;
//    }
//
//    @Override
//    public void update(String message) {
//        System.out.println("BotPlayer " + getName() + " received message: " + message);
//    }
//
//    @Override
//    public void setJudge(boolean isJudge) {
//        this.isJudge = isJudge;
//    }
//
//    @Override
//    public boolean isJudge() {
//        return isJudge;
//    }
//
//    @Override
//    public Card selectFavoriteRedApple(List<Card> submissions) {
//        return getRandomCard(submissions);
//    }
//
//    // Utility method for selecting a random card
//    private Card getRandomCard(List<Card> cards) {
//        if (cards == null || cards.isEmpty()) {
//            return null;
//        }
//        Random random = new Random();
//        return cards.get(random.nextInt(cards.size()));
//    }
//}
