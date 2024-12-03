//package com.Apples2Apples.game;
//
//import com.Apples2Apples.card.Card;
//import com.Apples2Apples.networking.GameServer;
//import com.Apples2Apples.observer.GameNotification;
//import com.Apples2Apples.observer.Observer;
//import com.Apples2Apples.player.Player;
//import com.Apples2Apples.player.PlayerFactory;
//import com.Apples2Apples.util.CardUtil;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//
//public class Game {
//    private List<Player> players;
//    private List<Card> greenApplesDeck;
//    private List<Card> redApplesDeck;
//    private Player currentJudge;
//    private int winningGreenApples;
//    private GameNotification gameNotification;
//    private GameServer gameServer;
//
//    private static final int SERVER_PORT = 2048;
//
//    public Game(List<Player> players) {
//        this.players = players;
//        this.greenApplesDeck = loadGreenAppleDeck();
//        this.redApplesDeck = loadRedAppleDeck();
//        this.winningGreenApples = determineWinningGreenApples(players.size());
//        shuffleDecks();
//        assignInitialCards();
//        randomizeJudge();
//        assignJudge();
//    }
//
//    private void startServer() {
//        try {
//            gameServer = new GameServer(SERVER_PORT);
//            new Thread(() -> gameServer.start()).start();
//            System.out.println("Server started on port " + SERVER_PORT);
//        } catch (IOException e) {
//            System.out.println("Error starting server: " + e.getMessage());
//        }
//    }
//
//
//    // Load Green Apples (cards) from the file
//// Load Green Apples (cards) from the file
//    private List<Card> loadGreenAppleDeck() {
//        return CardUtil.loadCardsFromFile("resources/greenApples.txt");
//    }
//
//    // Load Red Apples (cards) from the file
//    private List<Card> loadRedAppleDeck() {
//        return CardUtil.loadCardsFromFile("resources/redApples.txt");
//    }
//
//
//    // Determine how many green apples are needed to win based on the number of players
//    private int determineWinningGreenApples(int playerCount) {
//        if (playerCount == 4) return 8;
//        else if (playerCount == 5) return 7;
//        else if (playerCount == 6) return 6;
//        else if (playerCount == 7) return 5;
//        else return 4; // For 8 or more players
//    }
//    // Notify all players (observers)
////    private void notifyPlayers(String message) {
////        for (Observer player : players) {
////            player.update(message);
////        }
////    }
//    // Shuffle both the red and green apples decks
//    private void shuffleDecks() {
//        CardUtil.shuffleDeck(greenApplesDeck);
//        CardUtil.shuffleDeck(redApplesDeck);
//    }
//    // Notify all players (observers)
//    private void notifyPlayers(String message) {
//        for (Observer player : players) {
//            player.update(message);
//        }
//        gameServer.broadcastMessage(message);
//    }
//    // Adds bot players if the table size is less than the required number
//    private void addBotPlayersIfNeeded(int tableSize) {
//        int currentSize = players.size();
//        if (currentSize < tableSize) {
//            int botsToAdd = tableSize - currentSize;
//            for (int i = 0; i < botsToAdd; i++) {
//                String botName = "Bot" + (i + 1);
//                int botID = currentSize + i + 1;  // Unique ID for each bot
//                List<Card> botHand = new ArrayList<>();  // Empty hand for bots
//                players.add(PlayerFactory.createPlayer("bot", botID, null, botHand));  // Pass correct arguments
//            }
//        }
//    }
//
//    // Assign initial cards to players (7 red apples each)
//    private void assignInitialCards() {
//        for (Player player : players) {
//            // Make sure the player's hand is initialized
//            if (player.getHand() == null) {
//                player.setHand(new ArrayList<>());  // Initialize hand if it's null
//            }
//
//            // Assign 7 red apples to each player
//            for (int i = 0; i < 7; i++) {
//                Card card = redApplesDeck.get(i);
//                player.addCard(card);  // Add the card to the player's hand
//            }
//        }
//    }
//
//
//    // Randomize the judge
//    private void randomizeJudge() {
////        Random rand = new Random();
////        int randomIndex = rand.nextInt(players.size());
////        currentJudge = players.get(randomIndex); // Set the currentJudge field
////        gameNotification = new GameNotification();
////        gameNotification.setMessage(currentJudge.getName() + " is the judge.");
//        Random rand = new Random();
//        currentJudge = players.get(rand.nextInt(players.size()));
//        notifyPlayers(currentJudge.getName() + " is the judge.");
//    }
//
//    // Draw a green apple from the deck and notify players
//    private void drawGreenApple() {
//        if (!greenApplesDeck.isEmpty()) {
//            Card greenApple = greenApplesDeck.remove(0);
//            notifyPlayers("Green apple drawn: " + greenApple.getDescription());
//        }
//    }
//    // Phase B: Players submit a red apple
//    private void playRedApple() {
//        List<Card> redAppleSubmissions = new ArrayList<>();
//
//        // Collect red apple submissions from all players (except the judge)
//        for (Player player : players) {
//            if (!player.equals(currentJudge)) {
//                Card chosenCard = player.chooseRedAppleCard();
//                redAppleSubmissions.add(chosenCard);
//                player.removeCard(chosenCard); // Remove the selected card from the player's hand
//            }
//        }
//
//        // Randomize the order of the red apple submissions
//        Collections.shuffle(redAppleSubmissions);
//        gameNotification.setMessage("Red Apple submissions: ");
//        for (Card card : redAppleSubmissions) {
//            gameNotification.setMessage(card.getValue());
//        }
//
//        // Now we can call selectWinner, passing the submissions
//        selectWinner(redAppleSubmissions);
//    }
//
//
//    // Start the game logic
//    public void startGame() {
//        // Notify the players
//        gameNotification.setMessage("The game has started!");
//
//        // Start the rounds and handle the phases
//        while (true) {
//            // Example phase logic
//            drawGreenApple();
//            playRedApple();
//            replenishCards();
//
//            // Check if anyone has won
//            if (isGameOver()) break;
//
//            // Rotate the judge
//            rotateJudge();
//        }
//    }
//    // Start a new round and inform players
//    public void startNewRound() {
//        notifyPlayers("New round has started!");
//        notifyPlayers(currentJudge.getName() + " is the judge now.");
//        drawGreenApple();
//    }
//
//    // Handle phase of players submitting red apples
//    public void playersSubmitRedApple(String selectedRedApple) {
//        notifyPlayers("Players submit their red apples.");
//    }
//    // Phase C: Judge selects a winner
//    private void selectWinner(List<Card> redAppleSubmissions) {
//        Player judge = currentJudge;
//        // Simulate the judge selecting a favorite red apple
//        Card favoriteRedApple = judge.selectFavoriteRedApple(redAppleSubmissions);
//
//        // Notify all players of the selected winner
//        gameNotification.setMessage(judge.getName() + " selected: " + favoriteRedApple.getValue());
//
//        // The player who submitted the favorite red apple wins a green apple
//        for (Player player : players) {
//            if (player.hasSubmitted(favoriteRedApple)) {
//                player.addGreenApple();
//                gameNotification.setMessage(player.getName() + " wins a green apple!");
//                break;
//            }
//        }
//    }
//
//    // Replenish hands after each round
//    public void replenishCards() {
//        for (Player player : players) {
//            while (player.getHand().size() < 7) {
//                Card card = redApplesDeck.remove(0);
//                player.addCard(card);
//            }
//        }
//    }
//
//    // Check for winner at the end of the game
//    public void checkForWinner() {
//        for (Player player : players) {
//            if (player.getScore() >= winningGreenApples) {
//                notifyPlayers(player.getName() + " wins the game!");
//                return;
//            }
//        }
//    }
//    // Check if the game is over
//    private boolean isGameOver() {
//        for (Player player : players) {
//            if (player.getScore() >= winningGreenApples) {
//                gameNotification.setMessage(player.getName() + " has won the game!");
//                return true;
//            }
//        }
//        return false;
//    }
//    // Rotate the judge for the next round
//    private void rotateJudge() {
//        int currentJudgeIndex = players.indexOf(getJudge());
//        int nextJudgeIndex = (currentJudgeIndex + 1) % players.size(); // Cycle to the next player
//        gameNotification.setMessage(players.get(nextJudgeIndex).getName() + " is the new judge.");
//    }
//
//    // Helper method to get the current judge
//    private Player getJudge() {
//        return players.stream().filter(player -> player.isJudge()).findFirst().orElse(null);
//    }
//    private void assignJudge() {
//        if (!players.isEmpty()) {
//            players.get(0).setJudge(true);  // Assign the first player as the judge
//        }
//    }
//}
package com.Apples2Apples.game;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.networking.GameServer;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.observer.Observer;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.PlayerFactory;
import com.Apples2Apples.util.CardUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players;
    private List<Card> greenApplesDeck;
    private List<Card> redApplesDeck;
    private Player currentJudge;
    private int winningGreenApples;
    private GameNotification gameNotification;
    private GameServer gameServer;
    private static final int SERVER_PORT = 2048; // Example server port

    public Game(List<Player> players) {
        this.players = players;
        this.greenApplesDeck = loadGreenAppleDeck();
        this.redApplesDeck = loadRedAppleDeck();
        this.winningGreenApples = determineWinningGreenApples(players.size());
        shuffleDecks();
        assignInitialCards();
        randomizeJudge();
        assignJudge();

        // Initialize gameServer after the game starts
        try {
            gameServer = new GameServer(SERVER_PORT);
            new Thread(() -> gameServer.start()).start();
            System.out.println("Server started on port " + SERVER_PORT);
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    private List<Card> loadGreenAppleDeck() {
        //return CardUtil.loadCardsFromFile("resources/greenApples.txt");
        List<Card> cards = CardUtil.loadCardsFromFile("resources/greenApples.txt");
        System.out.println("Loaded Green Apple Cards:");
        for (Card card : cards) {
            System.out.println(card.getValue());  // Make sure the value is being loaded correctly
        }
        return cards;
    }

    private List<Card> loadRedAppleDeck() {
        return CardUtil.loadCardsFromFile("resources/redApples.txt");
    }

    private int determineWinningGreenApples(int playerCount) {
        if (playerCount == 4) return 8;
        else if (playerCount == 5) return 7;
        else if (playerCount == 6) return 6;
        else if (playerCount == 7) return 5;
        else return 4;
    }

    private void notifyPlayers(String message) {
        // Notify all players (observers)
        for (Observer player : players) {
            player.update(message);
        }
        if (gameServer != null) {
            gameServer.broadcastMessage(message);  // Only broadcast if gameServer is initialized
        }
    }

    private void shuffleDecks() {
        CardUtil.shuffleDeck(greenApplesDeck);
        CardUtil.shuffleDeck(redApplesDeck);
    }

    private void addBotPlayersIfNeeded(int tableSize) {
        int currentSize = players.size();
        if (currentSize < tableSize) {
            int botsToAdd = tableSize - currentSize;
            for (int i = 0; i < botsToAdd; i++) {
                String botName = "Bot" + (i + 1);
                int botID = currentSize + i + 1;  // Unique ID for each bot
                List<Card> botHand = new ArrayList<>();  // Empty hand for bots
                players.add(PlayerFactory.createPlayer("bot", botID, null, botHand));  // Pass correct arguments
            }
        }
    }

    private void assignInitialCards() {
        for (Player player : players) {
            if (player.getHand() == null) {
                player.setHand(new ArrayList<>());
            }

            for (int i = 0; i < 7; i++) {
                Card card = redApplesDeck.get(i);
                player.addCard(card);
            }
        }
    }

    private void randomizeJudge() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(players.size());
        currentJudge = players.get(randomIndex);
        gameNotification = new GameNotification();
        gameNotification.setMessage(currentJudge.getName() + " is the judge.");
    }

    private void drawGreenApple() {
//        if (!greenApplesDeck.isEmpty()) {
//            Card greenApple = greenApplesDeck.remove(0);
//            notifyPlayers("Green apple drawn: " + greenApple.getDescription());
//        }
        if (!greenApplesDeck.isEmpty()) {
            Card greenApple = greenApplesDeck.remove(0);  // Draw the first card
            notifyPlayers("Green apple drawn: " + greenApple.getValue());  // Use the card's value
        } else {
            notifyPlayers("No more green apples left to draw.");
        }
    }

    private void playRedApple() {
        List<Card> redAppleSubmissions = new ArrayList<>();

        for (Player player : players) {
            if (!player.equals(currentJudge)) {
                Card chosenCard = player.chooseRedAppleCard();
                redAppleSubmissions.add(chosenCard);
                player.removeCard(chosenCard);
            }
        }

        Collections.shuffle(redAppleSubmissions);
        gameNotification.setMessage("Red Apple submissions: ");
        for (Card card : redAppleSubmissions) {
            gameNotification.setMessage(card.getValue());
        }

        selectWinner(redAppleSubmissions);
    }

    public void startGame() {
        gameNotification.setMessage("The game has started!");

        while (true) {
            drawGreenApple();
            playRedApple();
            replenishCards();

            if (isGameOver()) break;

            rotateJudge();
        }
    }

    public void startNewRound() {
        notifyPlayers("New round has started!");
        notifyPlayers(currentJudge.getName() + " is the judge now.");
        drawGreenApple();
    }

    public void playersSubmitRedApple(String selectedRedApple) {
        notifyPlayers("Players submit their red apples.");
    }

    private void selectWinner(List<Card> redAppleSubmissions) {
        Player judge = currentJudge;
        Card favoriteRedApple = judge.selectFavoriteRedApple(redAppleSubmissions);

        gameNotification.setMessage(judge.getName() + " selected: " + favoriteRedApple.getValue());

        for (Player player : players) {
            if (player.hasSubmitted(favoriteRedApple)) {
                player.addGreenApple();
                gameNotification.setMessage(player.getName() + " wins a green apple!");
                break;
            }
        }
    }

    public void replenishCards() {
        for (Player player : players) {
            while (player.getHand().size() < 7) {
                Card card = redApplesDeck.remove(0);
                player.addCard(card);
            }
        }
    }

    public void checkForWinner() {
        for (Player player : players) {
            if (player.getScore() >= winningGreenApples) {
                notifyPlayers(player.getName() + " wins the game!");
                return;
            }
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getScore() >= winningGreenApples) {
                gameNotification.setMessage(player.getName() + " has won the game!");
                return true;
            }
        }
        return false;
    }

    private void rotateJudge() {
        int currentJudgeIndex = players.indexOf(getJudge());
        int nextJudgeIndex = (currentJudgeIndex + 1) % players.size();
        gameNotification.setMessage(players.get(nextJudgeIndex).getName() + " is the new judge.");
    }

    private Player getJudge() {
        return players.stream().filter(player -> player.isJudge()).findFirst().orElse(null);
    }

    private void assignJudge() {
        if (!players.isEmpty()) {
            players.get(0).setJudge(true);
        }
    }
}
