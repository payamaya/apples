package com.Apples2Apples;

import com.Apples2Apples.game.Game;
import com.Apples2Apples.game.GameSetup;
import com.Apples2Apples.judging.NotificationService;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.phases.*;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.util.InputHandler;
import com.Apples2Apples.util.JudgeSelector;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        GameSetup gameSetup = new GameSetup(inputHandler);

        // Step 1: Setup players
        List<Player> players = gameSetup.setupPlayers();

        // Step 2: Initialize GameNotification, NotificationService, and JudgeSelector
        GameNotification gameNotification = new GameNotification(); // Create a new GameNotification
        NotificationService notificationService = new NotificationService(gameNotification); // Create NotificationService
        JudgeSelector judgeSelector = new JudgeSelector(gameNotification); // Pass it to JudgeSelector

        // Step 3: Start the game
        Game game = new Game(players, players.size(), List.of(
                new DrawGreenApplePhase(),
                new SubmitRedApplePhase(),
                new JudgePhase(),
                new ReplenishHandPhase(),
                new RotateJudgePhase()
        ), judgeSelector, notificationService); // Pass NotificationService to Game

        game.startGame();
    }
}
