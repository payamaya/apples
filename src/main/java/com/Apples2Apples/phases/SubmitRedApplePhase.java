package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;
/**
 * Handles the phase where players submit their red apple cards.
 * This phase collects submissions from all players and prepares for judging.
 */
public class SubmitRedApplePhase implements GamePhase {
    /**
     * Manages the submission of red apple cards by players.
     * Updates the game state to reflect the cards played.
     *
     * @param game the current game instance on which the phase operates.
     */
    @Override
    public void execute(Game game) {
        game.playedRedApple();
    }
}