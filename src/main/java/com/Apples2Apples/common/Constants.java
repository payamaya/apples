package com.Apples2Apples.common;

public enum Constants {
    HAND_SIZE_LIMIT(7),
    SERVER_PORT(2048),
    WINNING_GREEN_APPLES_4(8),
    WINNING_GREEN_APPLES_5(7),
    WINNING_GREEN_APPLES_6(6),
    WINNING_GREEN_APPLES_7(5),
    WINNING_GREEN_APPLES_DEFAULT(4);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
