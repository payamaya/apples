package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.GameNotification;


import java.util.List;

public class JudgeUtil {
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
