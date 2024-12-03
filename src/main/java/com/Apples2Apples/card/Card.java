package com.Apples2Apples.card;


public abstract class Card {
    protected String value;

    // Constructor to initialize the value
    public Card(String value) {
        this.value = value;
    }
    public abstract String getDescription();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
