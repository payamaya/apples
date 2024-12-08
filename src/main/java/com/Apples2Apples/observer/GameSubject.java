package com.Apples2Apples.observer;

/**
 * The {@code Subject} interface defines methods for managing observers in the Observer pattern.
 * It allows observers to register, unregister, and be notified of changes.
 *
 * <p>This is the central interface that concrete subject classes (like {@code GameNotification}
 * and {@code PlayerNotification}) must implement to maintain the list of observers and notify them
 * of updates when the state changes.</p>
 */
public interface GameSubject {
    /**
     * Registers an observer to receive notifications.
     *
     * @param observer the observer to be added
     */
    void addObserver(GameObserver observer);
    /**
     * Unregisters an observer from receiving further notifications.
     *
     * @param observer the observer to be removed
     */
    void removeObserver(GameObserver observer);

    /**
     * Notifies all registered observers about changes.
     */
    void notifyObservers();
}