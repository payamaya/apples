package com.Apples2Apples.card;

/**
 * An abstract decorator for cards, allowing additional behavior or attributes
 * to be added to existing cards without modifying their original structure.
 * Used for implementing special card functionalities like wild cards.
 */
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