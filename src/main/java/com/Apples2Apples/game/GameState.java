package com.Apples2Apples.game;

import com.Apples2Apples.player.Player;

import java.util.List;
import java.util.Random;

public class GameState {
    private List<Player> players;
    private int currentJudgeIndex;
    private Player winner;

    public GameState(List<Player> players) {
        this.players = players;
        this.currentJudgeIndex = new Random().nextInt(players.size());
    }

    public Player getCurrentJudge() {
        return players.get(currentJudgeIndex);
    }

    public void setNextJudge() {
        currentJudgeIndex = (currentJudgeIndex + 1) % players.size();
    }

    public Player getWinner() {
        return winner;
    }

    public Player getRandomJudge() {
        return players.get(new Random().nextInt(players.size()));
    }
}
