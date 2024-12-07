package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

/**
 * The Judge interface extends the Player interface and defines the methods required for a player
 * to take on the role of a judge in the Apples to Apples game. The judge selects the favorite red apple card
 * from the submissions and determines the winner for each round.
 */
public interface Judge extends Player{
    /**
     * Allows the judge to select their favorite red apple card from a list of submissions.
     *
     * @param submissions The list of red apple cards submitted by players.
     * @return The judge's favorite red apple card.
     */
    Card selectFavoriteRedApple(List<Card> submissions);
    /**
     * Allows the judge to select a red apple card to be played in the game.
     *
     * @return The selected red apple card.
     */
    Card selectRedApple();
}
