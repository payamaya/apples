package com.Apples2Apples.card;


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
        if (this == obj) return true;  // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false;  // Check for null or different class
        Card card = (Card) obj;
        return value != null && value.equals(card.value);  // Compare based on the value field (or change this as needed)
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
