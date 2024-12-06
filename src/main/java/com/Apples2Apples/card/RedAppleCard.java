package com.Apples2Apples.card;

public class RedAppleCard extends Card {
    public RedAppleCard(String value) {
        super(value, CardType.RED);
    }
    @Override
    public String getDescription() {
        return "Red Apple Card with value: " + value;
    }
}