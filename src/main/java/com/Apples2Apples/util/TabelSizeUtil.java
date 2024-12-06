package com.Apples2Apples.util;

import com.Apples2Apples.common.Constants;

public class TabelSizeUtil {
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
