package com.Apples2Apples;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.networking.TCPServerFactory;
import com.Apples2Apples.phases.*;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.player.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players (between 4 and 8): ");
        int numPlayers = Math.max(4, Math.min(8, scanner.nextInt())); // Clamp to valid range

        List<Player> players = new ArrayList<>();
        System.out.println("Do you want to add online players? (yes/no): ");
        String response = scanner.next();


        for (int i = 0; i < numPlayers; i++) {
            List<Card> hand = new ArrayList<>();
            if (response.equalsIgnoreCase("yes")) {
                players.add(PlayerFactory.createPlayer(PlayerType.ONLINE, "Player" + (i + 1), hand, true));
            } else {
                players.add(PlayerFactory.createPlayer(PlayerType.LOCAL, "Player" + (i + 1), hand, true));
            }
        }

//        // Initialize network factory
//    IServerFactory serverFactory = new TCPServerFactory();
//
//    // Define the game phases
//    List<GamePhase> gamePhases = new ArrayList<>();
//    gamePhases.add(new DrawGreenApplePhase());
//    gamePhases.add(new SubmitRedApplePhase());
//    gamePhases.add(new JudgePhase());
//    gamePhases.add(new ReplenishHandPhase());
//    gamePhases.add(new RotateJudgePhase()); // Adding the RotateJudgePhase here
//
//    // Create and start the game
//    Game game = new Game(players, numPlayers, serverFactory, gamePhases);
//    game.startGame();
        Game game = new Game(players, numPlayers, new TCPServerFactory(), List.of(
                new DrawGreenApplePhase(),
                new SubmitRedApplePhase(),
                new JudgePhase(),
                new ReplenishHandPhase(),
                new RotateJudgePhase()
        ));
        game.startGame();
    }
}
