package com.Apples2Apples.card;

public class GreenAppleCard extends Card {
    public GreenAppleCard(String value) {
        super(value);
    }

    @Override
    public String getDescription() {
        return "Green Apple Card with value: " + value;
    }
}