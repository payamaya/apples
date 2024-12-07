package com.Apples2Apples.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code PlayerNotification} class implements the {@link Subject} interface
 * and functions similarly to {@code GameNotification}, but is intended for player-specific
 * notifications (e.g., player status changes, scores).
 * It maintains a list of observers and notifies them of any message updates related to players.
 */
public class PlayerNotification implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    /**
     * Sets the message for the player notification and notifies all observers.
     *
     * @param message the message to be broadcast to observers
     */
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
    /**
     * Adds an observer to the list of players to notify.
     *
     * @param observer the observer to be added
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    /**
     * Removes an observer from the list of players to notify.
     *
     * @param observer the observer to be removed
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    /**
     * Notifies all registered observers about the new message.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
