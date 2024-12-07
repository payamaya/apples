package com.Apples2Apples.card;

/**
 * Represents a special red apple card in the Apples to Apples game.
 * This card allows the player to fill in their own answer instead of using a predefined value.
 */
public class WildRedAppleCard extends CardDecorator {

    public WildRedAppleCard(Card decoratedCard) {
        super(decoratedCard.getValue(), CardType.RED, decoratedCard);

    }
    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Wild Card: Fill your own answer)";
    }
}