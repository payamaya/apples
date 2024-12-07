package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.Observer;

import java.util.List;
import java.util.Random;
/**
 * BotPlayer represents an automated player in the game. It implements the **Observer Pattern** to listen for game updates
 * and makes decisions based on random card selection.
 * It can also act as a judge if needed, deciding which red apple card is favored.
 */
public class BotPlayer extends AbstractPlayer implements Judge, Observer {
    private boolean isJudge;

    public BotPlayer(String name, boolean isJudge) {
        super(name);
        this.isJudge = isJudge;
    }

    @Override
    public Card chooseRedAppleCard() {
        return getRandomCard(getHand());
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
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
    public void update(String message) {
        System.out.println(getName() + " received update: " + message);
    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
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
