package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.net.Socket;
import java.util.List;

public class OnlinePlayer extends Player {
    private Socket socket;

    public OnlinePlayer(int playerID, Socket socket, List<Card> hand) {
        super(playerID, hand);  // Assuming the Player class has this constructor
        this.socket = socket;
    }

    @Override
    public Card selectRedApple() {
        // Placeholder: In a real game, this would interact with a network/server
        return hand.get(0); // Simplified
    }
}
