package com.Apples2Apples.game;

public class GameConfig {
    private static int handSizeLimit = 7;

    public static int getHandSizeLimit() {
        return handSizeLimit;
    }

    public static void setHandSizeLimit(int limit) {
        if (limit > 0) { // Ensure the limit is valid.
            handSizeLimit = limit;
        }
    }
}
