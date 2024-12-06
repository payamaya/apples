package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import java.net.Socket;
import java.util.List;

public class PlayerFactory {
    // Default method when only name is provided (with canSeeCards set to true by default)
    public static Player createPlayer(PlayerType type, String name) {
        return createPlayer(type, name, null, new Hand().getCards(), true); // Default 'canSeeCards' to true
    }

    public static Player createPlayer(PlayerType type, String name, Socket socket, List<Card> hand, boolean canSeeCards) {
        switch (type) {
            case LOCAL:
                return new LocalPlayer(name, canSeeCards);

            case BOT:
                return new BotPlayer(name, canSeeCards); // Pass canSeeCards to BotPlayer

            case ONLINE:
                if (socket == null) {
                    throw new IllegalArgumentException("Socket is required for online players");
                }
                return new OnlinePlayer(name, socket, canSeeCards);

            default:
                throw new IllegalArgumentException("Invalid player type");
        }
    }
}
