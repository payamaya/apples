package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.common.Constants;
import com.Apples2Apples.exception.CustomExceptions;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
/**
 * PlayerFactory is responsible for creating player instances based on the type of player required for the game.
 * It uses the **Factory Pattern** to create different types of players, such as Bot, Human, and Online players.
 */
public class PlayerFactory {

    public static Player createPlayer(PlayerType type, String name, List<Card> cards, boolean isJudge) {
        switch (type) {
            case LOCAL:
                return new HumanPlayer(name, cards, isJudge);
            case ONLINE:
                try {
                    // Example placeholder socket; replace with actual implementation
                    Socket socket = new Socket("127.0.0.1", Constants.SERVER_PORT.getValue());
                    // Create and return OnlinePlayer with socket
                    return new OnlinePlayer(name, socket);  // Name and socket are passed to OnlinePlayer
                } catch (IOException e) {
                    System.err.println("Failed to connect to the server. Switching to LOCAL player.");
                    return new HumanPlayer(name, cards, isJudge);
                }
            case BOT:
                return new BotPlayer(name, cards, isJudge);
            default:
                throw new IllegalArgumentException("Unknown player type: " + type);
        }
    }
}
