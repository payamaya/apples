package com.Apples2Apples.util;

import com.Apples2Apples.observer.Observer;
import com.Apples2Apples.player.Player;

import java.util.logging.Logger;

public class CardDisplayService implements Observer {
    private static final Logger logger = Logger.getLogger(CardDisplayService.class.getName());
    @Override
    public void update(String message) {

        logger.info(() -> "Notification received: " + message);
    }

    public void displayPlayerHand(Player player) {
        if (player.canSeeCards()) {
            logger.info(() -> player.getName() + "'s cards: " + player.getHand());
        }
    }
}
