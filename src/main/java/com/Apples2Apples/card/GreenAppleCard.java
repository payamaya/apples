package com.Apples2Apples.card;
/**
 * Represents a green apple card in the Apples to Apples game.
 * Green apple cards provide prompts (adjectives) for players to judge.
 */
public class GreenAppleCard extends Card {
    public GreenAppleCard(String value) {
        super(value, CardType.GREEN);
    }

    @Override
    public String getDescription() {
        return "Green Apple Card with value: " + value;
    }
}