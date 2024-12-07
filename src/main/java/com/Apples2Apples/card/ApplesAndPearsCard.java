package com.Apples2Apples.card;

/**
 * Represents a special red apple card in the Apples to Apples game.
 * This card allows the player to replace the current green apple card with a new one.
 */
public class ApplesAndPearsCard extends CardDecorator {

    public ApplesAndPearsCard(Card decoratedCard) {
        super(decoratedCard.getValue(), CardType.RED, decoratedCard);
    }

    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Apples & Pears: Replaces Green Apple)";
    }
}