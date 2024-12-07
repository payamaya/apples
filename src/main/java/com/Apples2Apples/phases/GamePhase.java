package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;

/**
 * Represents a phase in the Apples to Apples game.
 * Each phase implements specific game mechanics that occur sequentially
 * during gameplay. Implementing classes define the behavior of each phase.
 */
public interface GamePhase {
    /**
     * Executes the logic associated with the current game phase.
     *
     * @param game the current game instance on which the phase logic operates.
     */
    void execute(Game game);
}
