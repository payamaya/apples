package com.Apples2Apples.game;

import com.Apples2Apples.common.Constants;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.player.PlayerType;
import com.Apples2Apples.util.InputHandler;
import com.Apples2Apples.util.PlayerTypeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSetup {
    private InputHandler inputHandler;

    public GameSetup(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<Player> setupPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numPlayers;

        // Step 1: Validate number of players
        do {
            System.out.println("Enter the number of players (between 4 and 8): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            numPlayers = scanner.nextInt();
        } while (numPlayers < Constants.MIN_NUMBER.getValue() || numPlayers > Constants.MAX_NUMBER.getValue());

        // Step 2: Create players dynamically
        List<Player> players = new ArrayList<>();

        // Create the first player manually
        System.out.println("Enter player type for Player1 (LOCAL, ONLINE, or BOT): ");
        String playerTypeInput;

        do {
            playerTypeInput = scanner.next().toUpperCase();
            try {
                PlayerTypeValidator.validatePlayerType(playerTypeInput); // Validate player type input
                players.add(PlayerFactory.createPlayer(PlayerType.valueOf(playerTypeInput), "Player1", new ArrayList<>(), true));
                break; // Exit loop if valid input
            } catch (CustomExceptions.InvalidPlayerTypeException e) {
                System.out.println("Invalid player type. Please enter LOCAL, ONLINE, or BOT.");
            }
        } while (true); // Loop until valid input is entered

        // Step 3: Add the rest as Bot players
        while (players.size() < numPlayers) {
            players.add(PlayerFactory.createPlayer(PlayerType.BOT, "Bot" + (players.size() + 1), new ArrayList<>(), false));
        }

        return players;
    }
}
