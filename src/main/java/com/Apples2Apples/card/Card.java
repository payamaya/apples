package com.Apples2Apples.card;

/**
 * An abstract representation of a card in the Apples to Apples game.
 * Cards have a value, a type (red or green), and a description.
 * This serves as the base class for specific card types.
 */
public abstract class Card {
    protected String value;
    private final CardType cardType;

    // Constructor to initialize the value
    public Card(String value, CardType cardType) {
        this.value = value;
        this.cardType = cardType;
    }
    public abstract String getDescription();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public CardType getType() {
        return cardType;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value.equals(card.value) && cardType == card.cardType;  // Include cardType if necessary
    }


    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;  // Use value for hashCode, return 0 if value is null
    }

    @Override
    public String toString() {
         return cardType + " Card: " + value; // Customize this based on your fields
    }
}
