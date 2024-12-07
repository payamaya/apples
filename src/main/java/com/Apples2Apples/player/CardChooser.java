package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

/**
 * The CardChooser interface defines methods for selecting red apple cards in the Apples to Apples game.
 * This interface is typically implemented by players (such as BotPlayer, HumanPlayer, or OnlinePlayer)
 * who need to choose a favorite red apple card or choose a red apple to play.
 */
public interface CardChooser {
    /**
     * Selects the player's favorite red apple card from a list of submissions.
     *
     * @param submissions The list of red apple cards submitted by players.
     * @return The selected favorite red apple card.
     */
    Card selectFavoriteRedApple(List<Card> submissions);
    /**
     * Selects a red apple card to be played.
     *
     * @return The selected red apple card.
     */
    Card selectRedApple();
}
