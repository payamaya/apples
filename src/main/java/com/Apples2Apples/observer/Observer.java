package com.Apples2Apples.observer;

/**
 * The {@code Observer} interface defines the method that concrete observer classes
 * must implement to receive updates from a {@link Subject}.
 *
 * <p>Observers are notified whenever there is a state change or a message broadcasted
 * by the subject they are observing.</p>
 */
public interface Observer {
    /**
     * This method is called when the subject updates and needs to notify the observer.
     *
     * @param message the message sent by the subject to be processed by the observer
     */
    void update(String message);  // Method to notify observers about a change
}
