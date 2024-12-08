package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
/**
 * The Playable interface defines the core methods for a player in the Apples to Apples game.
 * It includes methods for managing a player's hand (adding, removing cards), checking if a card has been submitted,
 * and choosing a red apple card to play.
 *
 * This interface can be implemented by various types of players (e.g., BotPlayer, HumanPlayer, OnlinePlayer).
 */
public interface Playable {
    /**
     * Allows the player to choose a red apple card to play.
     *
     * @return The selected red apple card.
     */
    Card chooseRedAppleCard();
    /**
     * Adds a card to the player's hand.
     *
     * @param card The card to be added.
     */
    void addCard(Card card);
    /**
     * Removes a card from the player's hand.
     *
     * @param card The card to be removed.
     */
    void removeCard(Card card);
    /**
     * Checks if the player has already submitted the specified card.
     *
     * @param card The card to check.
     * @return true if the card has been submitted, false otherwise.
     */
    boolean hasSubmitted(Card card);

    // General notification update method
    void update(String message);
}