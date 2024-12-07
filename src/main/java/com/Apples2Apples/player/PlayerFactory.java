package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.net.Socket;
import java.util.List;
/**
 * PlayerFactory is responsible for creating player instances based on the type of player required for the game.
 * It uses the **Factory Pattern** to create different types of players, such as Bot, Human, and Online players.
 */
public class PlayerFactory {
    public static Player createPlayer(PlayerType type, String name, List<Card> hand, boolean isJudge) {
        return switch (type) {
            case BOT -> new BotPlayer(name, isJudge);
            case LOCAL -> new HumanPlayer(name);
            case ONLINE -> {
                if (hand == null) {
                    throw new IllegalArgumentException("OnlinePlayer requires a hand of cards.");
                }
                yield new OnlinePlayer(name, hand, new Socket()); // Provide a valid socket connection
            }
            default -> throw new IllegalArgumentException("Invalid player type.");
        };
    }
}
