package com.Apples2Apples.observer;

import com.Apples2Apples.exception.CustomExceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code PlayerNotification} class implements the {@link GameSubject} interface
 * and functions similarly to {@code GameNotification}, but is intended for player-specific
 * notifications (e.g., player status changes, scores).
 * It maintains a list of observers and notifies them of any message updates related to players.
 */
public class PlayerNotification implements GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();
    private String message;

    /**
     * Sets the message for the player notification and notifies all observers.
     *
     * @param message the message to be broadcast to observers
     */
    public void setMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new CustomExceptions.InvalidPlayerNotificationException("Player notification message cannot be null or empty.");
        }
        this.message = message;
        notifyObservers();
    }
    /**
     * Adds an observer to the list of players to notify.
     *
     * @param observer the observer to be added
     */
    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    /**
     * Removes an observer from the list of players to notify.
     *
     * @param observer the observer to be removed
     */
    @Override
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }
    /**
     * Notifies all registered observers about the new message.
     */
    @Override
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(message);
        }
    }
}
