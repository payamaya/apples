package com.Apples2Apples.card;

public abstract class CardDecorator extends Card {
    protected Card decoratedCard;

    public CardDecorator(String value, CardType cardType, Card decoratedCard) {
        super(value, cardType); // Pass value and cardType to the parent class (Card)
        this.decoratedCard = decoratedCard;
    }

   @Override
    public String getDescription() {
        return decoratedCard.getDescription();
    }
}