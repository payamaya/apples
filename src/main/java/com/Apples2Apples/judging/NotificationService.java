package com.Apples2Apples.judging;

import com.Apples2Apples.observer.GameNotification;


/**
 * The {@code NotificationService} class is responsible for sending game notifications
 * to players. It integrates with the Observer Pattern by utilizing {@link GameNotification}.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Send notifications about game progress and outcomes.</li>
 *   <li>Encapsulate notification logic for easy modification and extension.</li>
 * </ul>
 */
public class NotificationService {
    private final GameNotification gameNotification;
    /**
     * Constructs a new {@code NotificationService} with the specified game notification.
     *
     * @param gameNotification the notification mechanism used to send messages.
     */
    public NotificationService(GameNotification gameNotification) {
        this.gameNotification = gameNotification;
    }
    /**
     * Sends a notification message to all observers.
     *
     * @param message the message to send.
     */
    public void notify(String message) {
        gameNotification.setMessage(message);
    }
}
