package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.Player;


import java.util.List;
/**
 * The JudgeUtil class provides utility methods for handling judge actions in the Apples to Apples game.
 * It includes functionality for drawing green apple cards and notifying players about the actions.
 */
public class JudgeUtil {
    /**
     * Draws a green apple card from the green apples deck and notifies players about the action.
     *
     * @param greenApplesDeck The deck of green apple cards.
     * @param gameNotification The GameNotification object to notify about the drawn card.
     * @param players The list of players to notify about the green apple winner.
     * @return The drawn green apple card, or null if no green apples are left.
     */
    public static Card drawGreenApple(List<Card> greenApplesDeck, GameNotification gameNotification, List<Player> players) {
        if (greenApplesDeck.isEmpty()) {
            throw new CustomExceptions.JudgeUtilException("No more green apples left to draw.");
        }

        // Draw the first green apple card
        Card greenApple = greenApplesDeck.remove(0);

        // Notify players about the green apple drawn
        gameNotification.setMessage("Green apple drawn: " + greenApple.getValue());

        // Select a player randomly (this could be changed to another rule as per your game logic)
        Player winner = players.get((int) (Math.random() * players.size()));  // Randomly pick a player for this example

        // Notify who gets the green apple
        gameNotification.setMessage(winner.getName() + " won the green apple: " + greenApple.getValue());
        System.out.println(winner.getName() + " wins the green apple card: " + greenApple.getValue());

        // Increment the winner's score
        winner.incrementScore();

        return greenApple;
    }
}
