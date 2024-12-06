//package com.Apples2Apples.card;
//
//import com.Apples2Apples.player.Hand;
//
//import java.util.List;
//
//public class CardHandler implements Cardmanager{
//
//    // Method to deal cards to the player
//    public void dealCards(Hand hand, List<Card> cards, int handSizeLimit) {
//        for (int i = 0; i < handSizeLimit && !cards.isEmpty(); i++) {
//            hand.addCard(cards.remove(0));
//        }
//    }
//
//    // Method to remove a card from the player's hand
//    public void removeCard(Hand hand, Card card) {
//        hand.getCards().remove(card);
//    }
//}