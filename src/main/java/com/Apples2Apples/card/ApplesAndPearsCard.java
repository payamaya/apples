package com.Apples2Apples.card;

public class ApplesAndPearsCard extends CardDecorator {

    public ApplesAndPearsCard(Card decoratedCard) {
        super(decoratedCard.getValue(), CardType.RED, decoratedCard);
    }

    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Apples & Pears: Replaces Green Apple)";
    }
}