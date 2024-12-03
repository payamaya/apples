package com.Apples2Apples.card;

//package com.Apples2Apples.card;
//
//public class WildRedAppleCard extends RedAppleCard {
//
//    public WildRedAppleCard() {
//        super("Wild Card - Fill in your own description!");
//    }
//
//    public void setCustomDescription(String customDescription) {
//        System.out.println("Wild card customized with: " + customDescription);
//    }
//}
public class WildRedAppleCard extends CardDecorator {

    public WildRedAppleCard(Card decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public String getDescription() {
        return decoratedCard.getDescription() + " (Wild Card: Fill your own answer)";
    }
}