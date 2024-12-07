package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;
/**
 * Represents the phase where the game draws a green apple card.
 * This phase is part of the game flow and ensures that a green apple is drawn
 * for players to judge against the submitted red apples.
 */
public class DrawGreenApplePhase implements GamePhase {
    /**
     * Executes the logic for drawing a green apple card during the game.
     *
     * @param game the current game instance on which the phase operates.
     */
    @Override
    public void execute(Game game) {
        game.drawGreenApple();
    }
}