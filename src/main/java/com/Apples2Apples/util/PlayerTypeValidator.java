package com.Apples2Apples.util;

import com.Apples2Apples.exception.CustomExceptions;

public class PlayerTypeValidator {
    private static final String[] VALID_PLAYER_TYPES = {"LOCAL", "ONLINE", "BOT"};

    public static void validatePlayerType(String playerType) throws CustomExceptions.InvalidPlayerTypeException {
        for (String validType : VALID_PLAYER_TYPES) {
            if (playerType.equals(validType)) {
                return;  // valid type
            }
        }
        throw new CustomExceptions.InvalidPlayerTypeException("Invalid player type. Please enter LOCAL, ONLINE, or BOT.");
    }
}
