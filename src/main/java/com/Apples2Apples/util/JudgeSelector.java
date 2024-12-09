package com.Apples2Apples.util;

import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.Player;
import java.util.List;
import java.util.Random;

/**
 * The JudgeSelector class handles the random selection of a judge from the list of players.
 * Once a judge is selected, it notifies all players about the new judge.
 */
public class JudgeSelector {
    private final GameNotification gameNotification;

    /**
     * Constructor for JudgeSelector.
     *
     * @param gameNotification The GameNotification object used to notify about the new judge.
     */
    public JudgeSelector(GameNotification gameNotification) {
        this.gameNotification = gameNotification;
    }

    /**
     * Randomly selects a judge from the list of players, sets the player as a judge,
     * and sends a notification to all players about the new judge.
     *
     * @param players The list of players.
     * @return The player who was selected as the new judge.
     */
    public Player selectAndNotifyRandomJudge(List<Player> players) throws CustomExceptions.JudgeSelectorNotificationException {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("Player list cannot be empty");
        }

        // Select a random player as the judge
        Player selectedJudge = players.get(new Random().nextInt(players.size()));

        try {
            // Set the notification message to match the test expectation
            gameNotification.setMessage(selectedJudge.getName() + " is the new judge.");
            notifyObservers(gameNotification);
        } catch (Exception e) {
            throw new CustomExceptions.JudgeSelectorNotificationException("Failed to deliver notification about new judge", e);
        }

        return selectedJudge;
    }
    

    /**
     * Notify the observers (players) with the provided notification.
     *
     * @param notification The notification to be delivered to the observers.
     */
    private void notifyObservers(GameNotification notification) {
        // Implement the logic for notifying observers here
        System.out.println("Notification to all players: " + notification.getMessage());
    }
}
