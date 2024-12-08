package com.Apples2Apples.game;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.RedAppleSubmissionManager;
import com.Apples2Apples.common.Constants;
import com.Apples2Apples.deck.DeckManager;
import com.Apples2Apples.deck.DeckShuffler;
import com.Apples2Apples.judging.DefaultJudgingStrategy;
import com.Apples2Apples.judging.JudgeManager;
import com.Apples2Apples.judging.NotificationService;
import com.Apples2Apples.networking.GameServer;
import com.Apples2Apples.networking.INetworkServer;
import com.Apples2Apples.networking.IServerFactory;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.observer.GameObserver;
import com.Apples2Apples.phases.GamePhase;
import com.Apples2Apples.player.*;
import com.Apples2Apples.util.*;

import java.util.List;

/**
 * This class represents a game of Apples to Apples. It manages players, decks, judging,
 * and the overall game flow.
 */
public class Game {
    private List<Player> players;
    private Player currentJudge;
    private JudgeManager judgeManager;
    private int currentPhaseIndex;
    private List<GamePhase> phases;
    private IServerFactory serverFactory;
    private final List<Card> greenApplesDeck;
    private final List<Card> redApplesDeck;
    private final JudgeSelector judgeSelector;
    private final int winningGreenApples;

    
    private GameNotification gameNotification;
    private final INetworkServer networkManager;
    private GameServer gameServer;
    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    private final RedAppleSubmissionManager submissionManager = new RedAppleSubmissionManager();
    private final DeckManager deckManager;
    private PlayerManager playerManager;
    
    /**
     * Creates a new Game instance with the provided players, table size, and server factory.
     *
     * @param players       The list of players participating in the game.
     * @param tableSize     The desired size of the game table.
     * @param serverFactory The factory used to create the network server.
     */
    public Game(List<Player> players, int tableSize, IServerFactory serverFactory, List<GamePhase> phases) {
        this.players = players;
        this.networkManager = serverFactory.createServer();
        this.gameServer = (GameServer) networkManager;
        this.judgeSelector = new JudgeSelector(gameNotification);
        this.gameNotification = new GameNotification();
        this.deckManager = new DeckManager();
        this.serverFactory = serverFactory;
        this.judgeManager = judgeManager;
        this.phases = phases;
        this.currentPhaseIndex = 0;
        this.currentJudge = players.get(0);

        greenApplesDeck = loadGreenAppleDeck();
        redApplesDeck = loadRedAppleDeck();
        winningGreenApples = TabelSizeUtil.determineWinningGreenApples(players.size());
        judgeManager = new JudgeManager(new DefaultJudgingStrategy(), new NotificationService(gameNotification));
        playerManager = new PlayerManager();
        players.forEach(player -> gameNotification.addObserver((GameObserver) player));
        shuffleDecks();
        addBotPlayersIfNeeded(tableSize);
        dealInitialCards();
        randomizeJudge();
        assignJudge();
        startServer();
    }

    public List<Card> getRedAppleSubmissions() {
        return submissionManager.getSubmissions();
    }

    private void startServer() {
        try {
            networkManager.startServer();
            logger.info("Server started on port " + Constants.SERVER_PORT.getValue());
        } catch (Exception e) {
            logger.error("Error starting server: " + e.getMessage(), e);
        }
    }

    private List<Card> loadGreenAppleDeck() {
        return CardUtil.createGreenApplesFromFile("resources/greenApples.txt");
    }

    private List<Card> loadRedAppleDeck() {
        return CardUtil.createRedApplesFromFile("resources/redApples.txt");
    }

    private void shuffleDecks() {
        DeckShuffler.shuffleDeck(greenApplesDeck);
        DeckShuffler.shuffleDeck(redApplesDeck);
    }

    /**
     * Ensures the game has the correct number of players by adding bot players if needed.
     *
     * @param tableSize the desired number of players for the game
     */
    public void addBotPlayersIfNeeded(int tableSize) {
        playerManager.addBotPlayersIfNeeded(players, tableSize);  // Delegate to PlayerManager
    }

    // Use the DeckManager to deal initial cards to players
    private void dealInitialCards() {
        int handSize = Constants.HAND_SIZE_LIMIT.getValue();
        deckManager.dealCards(players, redApplesDeck, handSize);

        CardDisplayService displayService = new CardDisplayService();
        players.forEach(displayService::displayPlayerHand);
    }

    private void randomizeJudge() {
        currentJudge = judgeSelector.selectAndNotifyRandomJudge(players);
    }
    // Getter for JudgeManager
    public JudgeManager getJudgeManager() {
        return judgeManager;
    }

    // Getter for Players
    public List<Player> getPlayers() {
        return players;
    }

    // Getter for Current Judge
    public Player getCurrentJudge() {
        return currentJudge;
    }

    // Setter for Current Judge
    public void setCurrentJudge(Player currentJudge) {
        this.currentJudge = currentJudge;
    }
    public void notifyPlayers(String message) {
        gameNotification.setMessage(message);
    }
           public void startGame(){
                while(!isGameOver()){
                    GamePhase currentPhase = phases.get(currentPhaseIndex);
                    logger.info("********  The game has started! ********");
                    currentPhase.execute(this);

                    currentPhaseIndex = (currentPhaseIndex +1 ) % phases.size();
                }
               Player winner = getWinner();
                logger.info("Game over! The winner is: " + (winner != null ? winner.getName() : "No winner."));
           }
//    public void startGame() {
//        notifyPlayers("********  The game has started! ********");
//
//        while (!isGameOver()) {
//            nextPhase();
//        }
//        Player winner = getWinner();
//        notifyPlayers("Game over! The winner is: " + (winner != null ? winner.getName() : "No winner."));
//    }
    private boolean isGameOver() {
        return players.stream().anyMatch(player -> player.getScore() >= winningGreenApples);
    }
    public void nextPhase() {
        if (currentPhaseIndex < phases.size()) {
            phases.get(currentPhaseIndex).execute(this);
            currentPhaseIndex++;
        } else {
            rotateJudge();
            System.out.println("Game Over or Round Complete.");
        }
    }
    public void restartPhases() {
        currentPhaseIndex = 0;  // Reset to first phase
    }
    public void drawGreenApple() {
        JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification);
    }

    public void playedRedApple() {
        List<Card> submissions = submissionManager.collectSubmissions(players);
        selectWinner(submissions);
        // Rule: 11 Discard all submitted red apples after judging
        submissionManager.discardSubmissions(submissions);
    }

    public void selectWinner(List<Card> redAppleSubmissions) {
        if (currentJudge instanceof Judge) {
            judgeManager.selectWinner(redAppleSubmissions, (Judge) currentJudge, players);
        } else {
            throw new IllegalStateException("Current judge is not of type Judge.");
        }
    }


    private Player getWinner() {
        return players.stream().filter(player -> player.getScore() >= winningGreenApples).findFirst().orElse(null);
    }

    public void replenishCards() {
        int handSizeLimit = GameConfig.getHandSizeLimit();
        CardReplenisher.replenishAllPlayers(players, redApplesDeck, handSizeLimit);
    }

    // Rotate the judge to the next player
    public void rotateJudge() {
        currentJudge = judgeManager.rotateJudge(players, currentJudge);
    }

    private void assignJudge() {
        if (!players.isEmpty()) {
            players.get(0).setJudge(true);
        }
    }
}
