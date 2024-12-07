package com.Apples2Apples.card;

/**
 * Represents a red apple card in the Apples to Apples game.
 * Red apple cards are used by players to respond to the prompt provided by a green apple card.
 */
public class RedAppleCard extends Card {
    public RedAppleCard(String value) {
        super(value, CardType.RED);
    }
    @Override
    public String getDescription() {
        return "Red Apple Card with value: " + value;
    }
}