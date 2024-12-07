package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;

/**
 * Handles the phase of the game where the judge role rotates to the next player.
 * This ensures that every player gets an opportunity to be the judge.
 */
public class RotateJudgePhase implements GamePhase {
    /**
     * Rotates the judge role among players.
     * The new judge is determined and notified, and the game state is updated.
     *
     * @param game the current game instance on which the phase operates.
     */
    @Override
    public void execute(Game game) {
        Player nextJudge = game.getJudgeManager().rotateJudge(game.getPlayers(), game.getCurrentJudge());
        game.setCurrentJudge(nextJudge);
        game.notifyPlayers("The new Judge is: " + nextJudge.getName());
    }
}
