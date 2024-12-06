package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.Observer;  // Import the Observer interface

import java.util.List;
import java.util.logging.Logger;

public abstract class Player implements Observer {
    private static final Logger logger = Logger.getLogger(Player.class.getName());// Implement Observer here
    protected String name;
    protected HandManager handManager;
    protected int score;
    protected boolean isJudge;
    private boolean canSeeCards;

    private final PlayerNotificationHandler notificationHandler;

    public Player(String name) {
        this.name = name;
        this.handManager = new HandManager();
        this.score = 0;
        this.isJudge = false;
        this.canSeeCards = true;
        this.notificationHandler = new PlayerNotificationHandler(name);
    }

    public void setCanSeeCards(boolean canSeeCards) {
        this.canSeeCards = canSeeCards;
    }

    public boolean canSeeCards() {
        return canSeeCards;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return handManager.getCards();
    }

    public void addGreenApple() {
        score++;
    }

    public boolean isJudge() {
        return isJudge;
    }

    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
    }

    public void addCard(Card card) {
        handManager.addCard(card);
        notificationHandler.update(name + " received card: " + card);
        logger.info(() -> name + " received card: " + card);
    }

    public void removeCard(Card card) {
        handManager.removeCard(card);
        logger.info(() -> name + " removed card: " + card);
    }

    public abstract Card chooseCard();

    public abstract Card chooseRedAppleCard();

    public abstract Card selectRedApple();

    public abstract Card selectFavoriteRedApple(List<Card> redAppleSubmissions);

    public abstract boolean hasSubmitted(Card favoriteRedApple);

    // Implementing the Observer's update method
    @Override
    public void update(String message) {
        notificationHandler.update(message);
        logger.info(getName() + " received update: " + message);
    }

}
