package com.Apples2Apples.card;

public class WildRedAppleCard extends CardDecorator {

    public WildRedAppleCard(Card decoratedCard) {
        super(decoratedCard.getValue(), CardType.RED, decoratedCard);

    }
    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Wild Card: Fill your own answer)";
    }
}