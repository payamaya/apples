package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;

import java.util.List;

/**
 * The CardReplenisher class contains methods to replenish cards in the game.
 * It provides functionality to replenish cards for a single player or for all players
 * by drawing cards from the deck to ensure each player reaches the specified hand size.
 */
public class CardReplenisher {

    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    /**
     * Replenishes the hand of a single player by drawing cards from the deck.
     *
     * @param player The player whose cards are to be replenished.
     * @param deck The deck of cards to draw from.
     * @param handSizeLimit The maximum number of cards a player should have in their hand.
     */
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

    /**
     * Replenishes cards for all players in the game.
     *
     * @param players The list of players whose hands are to be replenished.
     * @param deck The deck of cards to draw from.
     * @param handSizeLimit The maximum number of cards each player should have in their hand.
     */
    public static void replenishAllPlayers(List<Player> players, List<Card> deck, int handSizeLimit) {
        try {
            for (Player player : players) {
                replenishCardsForPlayer(player, deck, handSizeLimit);
            }
        } catch (Exception e) {
            throw new CustomExceptions.CardReplenishException("Not enough cards in deck to replenish all players");
        }

    }
}
