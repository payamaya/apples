package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;

public class RotateJudgePhase implements GamePhase {
    @Override
    public void execute(Game game) {
        Player nextJudge = game.getJudgeManager().rotateJudge(game.getPlayers(), game.getCurrentJudge());
        game.setCurrentJudge(nextJudge);
        game.notifyPlayers("The new Judge is: " + nextJudge.getName());
    }
}
