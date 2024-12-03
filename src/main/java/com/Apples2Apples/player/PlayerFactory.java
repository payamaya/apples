package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    public static Player createPlayer(String playerType, int playerID, Socket socket, List<Card> hand) {
        switch (playerType.toLowerCase()) {
            case "local":
                return new LocalPlayer(playerID, hand != null ? hand : new ArrayList<>());  // Ensure hand is initialized
            case "bot":
                return new BotPlayer(playerID, hand != null ? hand : new ArrayList<>());
            case "online":
                return new OnlinePlayer(playerID, socket, hand != null ? hand : new ArrayList<>());
            default:
                throw new IllegalArgumentException("Invalid player type");
        }
    }

}
