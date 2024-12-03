package com.Apples2Apples.card;

public abstract class CardDecorator extends Card {
    protected Card decoratedCard;

    public CardDecorator(Card decoratedCard) {
        super(decoratedCard.getDescription());
        this.decoratedCard = decoratedCard;
    }

    @Override
    public String getValue() {
        return decoratedCard.getValue();
    }

    @Override
    public String getDescription() {
        return decoratedCard.getDescription();
    }
}