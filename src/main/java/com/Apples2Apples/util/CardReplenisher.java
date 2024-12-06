package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;

import java.util.List;

public class CardReplenisher {

    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    // Replenish cards for a single player
    public static void replenishCardsForPlayer(Player player, List<Card> deck, int handSizeLimit) {
        int cardsNeeded = handSizeLimit - player.getHand().size();
        int cardsToDraw = Math.min(cardsNeeded, deck.size());

        // Log missing cards if any
        if (cardsNeeded > cardsToDraw) {
            int missingCards = cardsNeeded - cardsToDraw;
            logger.warn(player.getName() + " is missing " + missingCards + " cards.");
        }
        // Add cards to player's hand, removing from deck
        for (int i = 0; i < cardsToDraw; i++) {
            player.addCard(deck.remove(0));
        }
    }

    // Replenish cards for all players, ensure all players get as many cards as possible
    public static void replenishAllPlayers(List<Player> players, List<Card> deck, int handSizeLimit) {
        for (Player player : players) {
            replenishCardsForPlayer(player, deck, handSizeLimit);
        }
    }
}
