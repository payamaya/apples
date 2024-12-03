package com.Apples2Apples.card;

//package com.Apples2Apples.card;
//
//public class ApplesAndPearsCard extends RedAppleCard {
//
//    public ApplesAndPearsCard() {
//        super("Apples and Pears - Special card effect.");
//    }
//
//    public void triggerSpecialEffect() {
//        System.out.println("Green apple card will be replaced after submissions.");
//    }
//}

public class ApplesAndPearsCard extends CardDecorator {

    public ApplesAndPearsCard(Card decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Apples & Pears: Replaces Green Apple)";
    }
}