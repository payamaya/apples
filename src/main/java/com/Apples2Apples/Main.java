package com.Apples2Apples;

import com.Apples2Apples.common.Constants;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.game.GameServer;
import com.Apples2Apples.phases.*;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.player.PlayerType;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.util.JudgeSelector;
import com.Apples2Apples.judging.NotificationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
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
        String playerTypeInput = scanner.next().toUpperCase();
        PlayerType playerType;

        try {
            playerType = PlayerType.valueOf(playerTypeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid player type. Defaulting to BOT.");
            playerType = PlayerType.BOT;
        }

        players.add(PlayerFactory.createPlayer(playerType, "Player1", new ArrayList<>(), true));

        // Step 3: Add the rest as Bot players
        while (players.size() < numPlayers) {
            players.add(PlayerFactory.createPlayer(PlayerType.BOT, "Bot" + (players.size() + 1), new ArrayList<>(), false));
        }

        // Step 4: Initialize GameNotification, NotificationService, and JudgeSelector
        GameNotification gameNotification = new GameNotification(); // Create a new GameNotification
        NotificationService notificationService = new NotificationService(gameNotification); // Create NotificationService
        JudgeSelector judgeSelector = new JudgeSelector(gameNotification); // Pass it to JudgeSelector

        // Step 5: Start the game
        Game game = new Game(players, numPlayers, List.of(
                new DrawGreenApplePhase(),
                new SubmitRedApplePhase(),
                new JudgePhase(),
                new ReplenishHandPhase(),
                new RotateJudgePhase()
        ), judgeSelector, notificationService); // Pass NotificationService to Game

        game.startGame();
    }
}
