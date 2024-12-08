package com.Apples2Apples.phases;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.util.LoggerUtil;

import java.util.List;

/**
 * Handles the judging phase of the game.
 * During this phase, the judge evaluates submitted red apple cards and selects a winner.
 */
public class JudgePhase implements GamePhase {
    /**
     * Executes the judging logic where the judge selects the winning red apple card.
     *
     * @param game the current game instance on which the phase operates.
     */
    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    @Override
    public void execute(Game game) {
        try {
            List<Card> submissions = game.getRedAppleSubmissions();
            game.selectWinner(submissions);
        } catch (CustomExceptions.InvalidGameStateException e) {
            logger.error("Invalid game state during judging phase: " + e.getMessage(), e);
            // Handle the error, e.g., notify players, end the game
        }
    }

}