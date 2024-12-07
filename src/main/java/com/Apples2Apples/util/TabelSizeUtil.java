package com.Apples2Apples.util;

import com.Apples2Apples.common.Constants;

/**
 * The TabelSizeUtil class contains a utility method for determining the number of green apples required
 * for a winning condition based on the number of players in the game.
 */
public class TabelSizeUtil {
    /**
     * Determines the number of green apples needed for a winning condition based on the player count.
     *
     * @param playerCount The number of players in the game.
     * @return The number of green apples required to win.
     */
    public static int determineWinningGreenApples(int playerCount) {
        return switch (playerCount) {
            case 4 -> Constants.WINNING_GREEN_APPLES_4.getValue();
            case 5 -> Constants.WINNING_GREEN_APPLES_5.getValue();
            case 6 -> Constants.WINNING_GREEN_APPLES_6.getValue();
            case 7 -> Constants.WINNING_GREEN_APPLES_7.getValue();
            default -> Constants.WINNING_GREEN_APPLES_DEFAULT.getValue();
        };
    }
}
