package com.Apples2Apples.deck;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.util.LoggerUtil;

import java.util.List;

/**
 * Manages card dealing operations in the Apples to Apples game.
 * Responsible for assigning cards to players from the red apple deck.
 */
public class DeckManager {
    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    // Deals cards to each player based on hand size
    public void dealCards(List<Player> players, List<Card> redApplesDeck, int handSize) {
        for (Player player : players) {
            assignCardsToPlayer(player, redApplesDeck, handSize);
        }
    }

    // Helper method to assign a specific number of cards to a player
    private void assignCardsToPlayer(Player player, List<Card> deck, int handSize) {
        for (int i = 0; i < handSize && !deck.isEmpty(); i++) {

            try {
                player.addCard(deck.removeFirst());  // Deal the card from the top of the deck
            } catch (IndexOutOfBoundsException e) {
                logger.error("Error dealing card to player: " + player.getName(), e);
            }
        }
    }
}
