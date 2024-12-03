
//package com.Apples2Apples;
//import com.Apples2Apples.model.*;
//import com.Apples2Apples.model.Observer;
//import com.Apples2Apples.util.FileReaderUtil;
//import com.Apples2Apples.util.CardUtil;
//
//import java.util.*;
//
//public class Game implements SubjectObserver {
//
//    private List<IPlayer> players;
//    private int numberOfPlayers;
//    private List<String> redApplesDeck;
//    private List<String> greenApplesDeck;
//    private IPlayer judge;
//    private List<Integer> greenAppleScores;
//    private List<Observer> observers;  // List of observers (players)
//
//    public Game(int numberOfPlayers) {
//        this.players = new ArrayList<>();
//        this.greenAppleScores = new ArrayList<>();
//        this.redApplesDeck = new ArrayList<>();
//        this.greenApplesDeck = new ArrayList<>();
//        this.observers = new ArrayList<>();
//        initializeGame();
//    }
//
//    // Add an observer to the game
//    @Override
//    public void registerObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    // Remove an observer
//    @Override
//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }
//
//    // Notify all observers
//    @Override
//    public void notifyObservers(String message) {
//        for (Observer observer : observers) {
//            observer.update(message);  // Notify each player (observer)
//        }
//    }
//
//    @Override
//    public void startGame() {
//        // Deal red apples and select a random judge
//        dealRedApples();
//        selectRandomJudge();
//
//        // Game loop for multiple rounds
//        for (int round = 1; round <= 3; round++) {
//            System.out.println("\n--- Round " + round + " ---");
//
//            // Draw a green apple (judge does this)
//            String greenApple = drawGreenApple();
//            System.out.println("Green apple drawn: " + greenApple);
//
//            // Players (except the judge) play their cards
//            List<String> submittedCards = new ArrayList<>();
//            for (IPlayer player : players) {
//                if (!player.isJudge()) {
//                    String card = player.playCard(greenApple);
//                    if (!card.isEmpty()) {
//                        submittedCards.add(card);  // Only add non-empty cards
//                    }
//                }
//            }
//
//            // Shuffle and display cards in random order
//            CardUtil.shuffleDeck(submittedCards);
//            System.out.println("Shuffled cards: " + submittedCards);
//
//            // Judge selects a winner (just pick randomly for now)
//            if (!submittedCards.isEmpty()) {
//                String winnerCard = submittedCards.get(new Random().nextInt(submittedCards.size()));
//                System.out.println("Judge selects: " + winnerCard);
//
//                // Announce winner and update score
//                int winnerIndex = players.indexOf(judge);  // Adjust this logic to handle actual winner selection
//                greenAppleScores.set(winnerIndex, greenAppleScores.get(winnerIndex) + 1);
//                announceWinner(winnerIndex);
//            }
//
//            // Replenish red apples
//            replenishRedApples();
//
//            // Change the judge
//            switchJudge();
//        }
//
//        // After all rounds are completed, announce the overall winner
//        announceOverallWinner();
//    }
//
//    // The new announceWinner method: Announce the winner of the round
//    private void announceWinner(int winnerIndex) {
//        String winnerMessage = "Player " + winnerIndex + " wins this round!";
//        System.out.println(winnerMessage);
//        notifyPlayers(winnerMessage);  // Notify all players about the round winner
//    }
//
//    private void announceOverallWinner() {
//        int maxScore = 0;
//        int winnerID = -1;
//        for (int i = 0; i < greenAppleScores.size(); i++) {
//            if (greenAppleScores.get(i) > maxScore) {
//                maxScore = greenAppleScores.get(i);
//                winnerID = i;
//            }
//        }
//        String winnerMessage = "Player " + winnerID + " wins with " + maxScore + " green apples!";
//        System.out.println(winnerMessage);
//        notifyPlayers(winnerMessage);  // Notify all players
//    }
//
//    private void switchJudge() {
//        int currentJudgeIndex = players.indexOf(judge);
//        judge = players.get((currentJudgeIndex + 1) % players.size());
//        judge.setJudge(true);
//        System.out.println("New judge is Player " + judge.getPlayerID());
//    }
//
//    private void replenishRedApples() {
//        // Logic to replenish red apples at the end of each round
//        System.out.println("Replenishing red apples...");
//    }
//
//    // Other methods like dealRedApples(), drawGreenApple() would go here...
//}


