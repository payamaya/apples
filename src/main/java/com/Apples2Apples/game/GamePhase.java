package com.Apples2Apples.game;//package com.Apples2Apples.game;
//
//public abstract class GamePhase implements IGamePhase {
//
//    public final void executePhase() {
//        initializePhase();
//        performPhase();
//        completePhase();
//    }
//}

public abstract class GamePhase {
    public abstract void execute();
}