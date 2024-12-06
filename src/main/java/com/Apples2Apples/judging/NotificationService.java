package com.Apples2Apples.judging;

import com.Apples2Apples.observer.GameNotification;

public class NotificationService {
    private final GameNotification gameNotification;

    public NotificationService(GameNotification gameNotification) {
        this.gameNotification = gameNotification;
    }

    public void notify(String message) {
        gameNotification.setMessage(message);
    }
}
