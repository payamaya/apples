package com.Apples2Apples.util;

import com.Apples2Apples.judging.NotificationService;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.Player;
import java.util.List;
import java.util.Random;

public class JudgeSelector {
    private final GameNotification gameNotification;

    public JudgeSelector(GameNotification gameNotification) {
        this.gameNotification = gameNotification;
    }

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
