package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.PlayerObserver;


import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * BotPlayer represents an automated player in the game. It implements the **Observer Pattern** to listen for game updates
 * and makes decisions based on random card selection.
 * It can also act as a judge if needed, deciding which red apple card is favored.
 */
public class BotPlayer extends AbstractPlayer implements Judge, PlayerObserver {
    private static final Logger logger = Logger.getLogger(BotPlayer.class.getName());
    private boolean isJudge;
    private String message;

    public BotPlayer(String name, List<Card> cards, boolean isJudge) {
        super(name);
        this.isJudge = isJudge;
        setHand(cards);  // Set the player's hand based on provided cards
    }

    @Override
    public Card chooseRedAppleCard() {
//        logger.info(getName() + " (BOT) is selecting a red apple card...");
        if (hand.getCards().isEmpty()) {
            throw new IllegalStateException("No cards in BOT's hand.");
        }
        return hand.getCards().get((int) (Math.random() * hand.getCards().size())); // Random selection
    }

    @Override
    public void update(String message) {

    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        if (!isJudge) {
            throw new UnsupportedOperationException("Only a judge can select a favorite card.");
        }
        return getRandomCard(submissions);
    }

    @Override
    public Card selectRedApple() {
        return null; // Bot does not select the red apple itself.
    }

    @Override
    public boolean canSeeCards() {
        return false;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {}

    @Override
    public void update() {
        System.out.println(getName() + " received update: " + message);
    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
        // Only update the bot if it's the bot's state change
        if (isJudge) {
            logger.info(getName() + " is now the judge.");
        }
    }

    @Override
    public boolean isJudge() {
        return isJudge;
    }

    private Card getRandomCard(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }
}
