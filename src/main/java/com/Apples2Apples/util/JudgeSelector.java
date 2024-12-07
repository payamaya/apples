package com.Apples2Apples.util;

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
    public Player selectAndNotifyRandomJudge(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Player list cannot be empty");
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(players.size());
        Player newJudge = players.get(randomIndex);

        newJudge.setJudge(true);
        gameNotification.setMessage(newJudge.getName() + " is the new judge!");

        return newJudge;
    }
}
