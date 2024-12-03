package com.Apples2Apples.game;

import com.Apples2Apples.player.Player;

import java.util.List;

public class ScoreTracker {
    public boolean isGameOver(List<Player> players) {
        for (Player player : players) {
            if (player.getScore() >= 8) {  // For 4 players, 8 green apples wins.
                return true;
            }
        }
        return false;
    }

    public void trackScore(Player player) {
        player.addGreenApple();
    }
}