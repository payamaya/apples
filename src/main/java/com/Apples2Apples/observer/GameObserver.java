package com.Apples2Apples.observer;

/**
 * The {@code Observer} interface defines the method that concrete observer classes
 * must implement to receive updates from a {@link GameSubject}.
 *
 * <p>Observers are notified whenever there is a state change or a message broadcasted
 * by the subject they are observing.</p>
 */
public interface GameObserver {
    /**
     * This method is called when the subject updates and needs to notify the observer.
     */
    void update();  // Method to notify observers about a change
}
