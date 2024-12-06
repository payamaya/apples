package com.Apples2Apples.phases;

import com.Apples2Apples.game.Game;

public class ReplenishHandPhase implements GamePhase {
    @Override
    public void execute(Game game) {
        game.replenishCards();
    }
}