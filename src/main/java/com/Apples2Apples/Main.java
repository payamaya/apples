package com.Apples2Apples;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.judging.DefaultJudgingStrategy;
import com.Apples2Apples.judging.JudgeManager;
import com.Apples2Apples.judging.NotificationService;
import com.Apples2Apples.networking.IServerFactory;
import com.Apples2Apples.networking.TCPServerFactory;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.phases.*;
import com.Apples2Apples.player.Hand;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.player.PlayerType;
import com.Apples2Apples.util.DeckManager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("Enter the number of players (between 4 and 8): ");
////        int numPlayers = Math.max(4, Math.min(8, scanner.nextInt())); // Clamp to valid range
////
////        List<Player> players = new ArrayList<>();
////        System.out.println("Do you want to add online players? (yes/no): ");
////        String response = scanner.next();
////
////        for (int i = 0; i < numPlayers; i++) {
////            Hand hand = new Hand();
////            Socket socket = null;
////            if (response.equalsIgnoreCase("yes")) {
////                socket = new Socket();  // Placeholder: Replace with actual socket logic.
////                players.add(PlayerFactory.createPlayer(PlayerType.ONLINE, "Player" + (i + 1),  socket,hand.getCards(),true));
////            } else {
////                players.add(PlayerFactory.createPlayer(PlayerType.LOCAL, "Player" + (i + 1), null, hand.getCards(),true));
////            }
////        }
////        // Initialize network factory (TCP, UDP, etc.)
////        IServerFactory serverFactory = new TCPServerFactory();
////
////        // Initialize the list of game phases
////        List<GamePhase> gamePhases = new ArrayList<>();
////        gamePhases.add(new DrawGreenApplePhase());
////        gamePhases.add(new SubmitRedApplePhase());
////        gamePhases.add(new JudgePhase());
////        gamePhases.add(new ReplenishHandPhase());
////        Game game = new Game(players, numPlayers, serverFactory, gamePhases);
////        game.startGame();
////    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of players (between 4 and 8): ");
    int numPlayers = Math.max(4, Math.min(8, scanner.nextInt())); // Clamp to valid range

    List<Player> players = new ArrayList<>();
    System.out.println("Do you want to add online players? (yes/no): ");
    String response = scanner.next();

    for (int i = 0; i < numPlayers; i++) {
        Hand hand = new Hand();
        if (response.equalsIgnoreCase("yes")) {
            // Placeholder: Replace with actual socket handling
            players.add(PlayerFactory.createPlayer(PlayerType.ONLINE, "Player" + (i + 1), null, hand.getCards(), true));
        } else {
            players.add(PlayerFactory.createPlayer(PlayerType.LOCAL, "Player" + (i + 1), null, hand.getCards(), true));
        }
    }

    // Initialize network factory
    IServerFactory serverFactory = new TCPServerFactory();

    // Define the game phases
    List<GamePhase> gamePhases = new ArrayList<>();
    gamePhases.add(new DrawGreenApplePhase());
    gamePhases.add(new SubmitRedApplePhase());
    gamePhases.add(new JudgePhase());
    gamePhases.add(new ReplenishHandPhase());
    gamePhases.add(new RotateJudgePhase()); // Adding the RotateJudgePhase here

    // Create and start the game
    Game game = new Game(players, numPlayers, serverFactory, gamePhases);
    game.startGame();
}
}
