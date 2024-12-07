package com.Apples2Apples.util;

import com.Apples2Apples.observer.Observer;
import com.Apples2Apples.player.Player;

import java.util.logging.Logger;
/**
 * The CardDisplayService class implements the Observer interface to handle game notifications
 * and display player hands. It logs messages about game updates and displays a player's hand of cards
 * if they are allowed to see their cards.
 *
 * The CardDisplayService subscribes to updates from game events and notifies players of changes.
 */
public class CardDisplayService implements Observer {
    private static final Logger logger = Logger.getLogger(CardDisplayService.class.getName());
    /**
     * Updates the display with the provided message from the game event.
     *
     * @param message The message to log.
     */
    @Override
    public void update(String message) {

        logger.info(() -> "Notification received: " + message);
    }
    /**
     * Displays the player's hand if they are allowed to see it.
     *
     * @param player The player whose hand is to be displayed.
     */
    public void displayPlayerHand(Player player) {
        if (player.canSeeCards()) {
            logger.info(() -> player.getName() + "'s cards: " + player.getHand());
        }
    }
}
