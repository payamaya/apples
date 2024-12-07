package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

/**
 * The Player interface defines the core methods for a player in the Apples to Apples game.
 * It extends **Playable** and includes specific methods for managing a player's hand, score, and game notifications.
 * It also defines methods for the Judge role, which can be implemented by certain player types.
 */
public interface Player extends Playable {
    String getName();
    boolean canSeeCards();
    void setCanSeeCards(boolean canSeeCards);
    int getScore();
    void incrementScore();
    void setHand(List<Card> cards);
    List<Card> getHand();

    // General notification update method
    void update(String message);

    // This could be part of the Judge functionality, not every player needs this.
    void setJudge(boolean b);
    boolean isJudge();
}
