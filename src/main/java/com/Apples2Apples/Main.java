package com.Apples2Apples;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Assuming no socket is needed for local players, so passing null
        List<Player> players = new ArrayList<>();
        int tableSize = 4;  // Example table size, can be taken from user input

        // Scanner to accept user input for table size
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players (between 4 and 8): ");
        tableSize = scanner.nextInt();

        // Ensure the number of players is between 4 and 8, adjust if needed
        if (tableSize < 4) tableSize = 4;
        if (tableSize > 8) tableSize = 8;
        
        for (int i = 0; i < tableSize; i++) {
            String playerName = "Player " + (i + 1);
            int playerID = i + 1;
            List<Card> hand = new ArrayList<>();
            players.add(PlayerFactory.createPlayer("local", playerID, null, hand));  
        }

        Game game = new Game(players);
        game.startGame();
    }
}