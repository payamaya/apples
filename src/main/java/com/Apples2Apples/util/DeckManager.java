//package com.Apples2Apples.util;
//
//
//import com.Apples2Apples.card.Card;
//import com.Apples2Apples.player.Player;
//
//import java.util.List;
//
//public class DeckManager {
//
//    // Deals cards to each player based on hand size
//    public void dealCards(List<Player> players, List<Card> redApplesDeck, int handSize) {
//        for (Player player : players) {
//            assignCardsToPlayer(player, redApplesDeck, handSize);
//        }
//    }
//
//    // Helper method to assign a specific number of cards to a player
//    private void assignCardsToPlayer(Player player, List<Card> deck, int handSize) {
//        for (int i = 0; i < handSize && !deck.isEmpty(); i++) {
//            player.addCard(deck.removeFirst());  // Deal the card from the top of the deck
//        }
//    }
//}
