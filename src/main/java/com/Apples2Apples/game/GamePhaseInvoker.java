package com.Apples2Apples.game;

public class GamePhaseInvoker {
    public void invokePhase(GamePhase phase) {
        phase.execute();
    }
}