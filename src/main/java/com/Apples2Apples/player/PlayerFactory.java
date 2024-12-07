package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.net.Socket;
import java.util.List;

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
