package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.GameNotification;


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
     * @return The drawn green apple card, or null if no green apples are left.
     */
    public static Card drawGreenApple(List<Card> greenApplesDeck, GameNotification gameNotification) {
        if (greenApplesDeck.isEmpty()) {
            gameNotification.setMessage("No more green apples left to draw.");
            return null;
        }
        Card greenApple = greenApplesDeck.remove(0);
        gameNotification.setMessage("Green apple drawn: " + greenApple.getValue());
        return greenApple;
    }
}
