package com.Apples2Apples.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code GameNotification} class implements the {@link GameSubject} interface
 * to allow observers to register and receive notifications about game-related events.
 * It maintains a list of observers and notifies them when a new message is set.
 *
 * <p>This class is used to broadcast game-related messages, such as round updates
 * or game state changes, to all interested observers.</p>
 */
public class GameNotification implements GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();
    private String message;

    /**
     * Sets the notification message and notifies all registered observers.
     *
     * @param message the message to notify observers about
     */
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
    /**
     * Retrieves the current message being broadcasted to observers.
     *
     * @return the current notification message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Adds an observer to the list of observers to be notified.
     *
     * @param observer the observer to add
     */
    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    /**
     * Removes an observer from the list of observers.
     *
     * @param observer the observer to remove
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