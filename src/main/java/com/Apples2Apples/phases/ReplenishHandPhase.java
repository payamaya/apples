package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;
/**
 * Represents the ReplenishHandPhase of the Apples to Apples game.
 * During this phase, each player is dealt enough cards to ensure they have
 * seven cards in their hand. This phase occurs after each round.
 */
public class ReplenishHandPhase implements GamePhase {
    /**
     * Executes the logic for replenishing players' hands with cards.
     * Ensures that each player has seven cards at the end of this phase.
     *
     * @param game the current game instance on which the phase operates.
     */
    @Override
    public void execute(Game game) {
        game.replenishCards();
    }
}