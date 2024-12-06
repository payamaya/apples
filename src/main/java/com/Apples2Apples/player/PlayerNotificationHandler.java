package com.Apples2Apples.player;

import com.Apples2Apples.observer.Observer;

public class PlayerNotificationHandler implements Observer {
    private final String playerName;

    public PlayerNotificationHandler(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void update(String message) {
        System.out.println(playerName + " received notification: " + message);
    }
}
