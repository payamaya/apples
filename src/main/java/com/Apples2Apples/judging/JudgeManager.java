package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Judge;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.util.LoggerUtil;

import java.util.List;

/**
 * The {@code JudgeManager} class manages the judging process during gameplay.
 * It handles the selection of winning cards, rotates the judge role among players,
 * and provides notifications about the game's progress.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Facilitate the judging process using a given {@link JudgingStrategy}.</li>
 *   <li>Send notifications to players through the {@link NotificationService}.</li>
 *   <li>Rotate the judge role among players after each round.</li>
 * </ul>
 *
 * <h2>Design Patterns</h2>
 * <ul>
 *   <li><b>Strategy Pattern:</b> Allows for different judging strategies by
 *       accepting a {@code JudgingStrategy} implementation.</li>
 *   <li><b>Dependency Injection:</b> Relies on constructor injection for
 *       {@link NotificationService} and {@link JudgingStrategy}.</li>
 * </ul>
 */
public class JudgeManager {
    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    private final JudgingStrategy judgingStrategy;
    private final NotificationService notificationService;

    /**
     * Constructs a new {@code JudgeManager} with the specified strategy and notification service.
     *
     * @param judgingStrategy    the strategy used to select the winning card.
     * @param notificationService the service used to send game notifications.
     */
    public JudgeManager(JudgingStrategy judgingStrategy, NotificationService notificationService) {
        this.judgingStrategy = judgingStrategy;
        this.notificationService = notificationService;
    }
    /**
     * Selects the winner of the round based on red apple submissions.
     *
     * @param redAppleSubmissions the submitted red apple cards.
     * @param judge               the current judge.
     * @param players             the list of players in the game.
     */
    public void selectWinner(List<Card> redAppleSubmissions, Judge judge, List<Player> players) {
        if (redAppleSubmissions.isEmpty()) {
            notificationService.notify("No red apple submissions available.");
            return;
        }

        try {
            Card favoriteRedApple = judge.selectFavoriteRedApple(redAppleSubmissions);
            notificationService.notify("Judge selected: " + favoriteRedApple);

            Player winningPlayer = findPlayerWhoSubmitted(favoriteRedApple, players);
            if (winningPlayer != null) {
                winningPlayer.incrementScore();
                notificationService.notify(winningPlayer.getName() + " wins this round!");
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            logger.error("Error selecting winner: " + e.getMessage(), e);

        }
    }

    private Player findPlayerWhoSubmitted(Card card, List<Player> players) {
        for (Player player : players) {
            if (player.hasSubmitted(card)) {
                return player;
            }
        }
        return null;
    }
    /**
     * Rotates the judge role to the next player in the list.
     *
     * @param players      the list of players in the game.
     * @param currentJudge the current judge.
     * @return the next player to act as judge.
     */
    public Player rotateJudge(List<Player> players, Player currentJudge) {
        int currentJudgeIndex = players.indexOf(currentJudge);
        currentJudge.setJudge(false); // The current judge is no longer the judge

        // Find the next player (loop back to the first if we are at the end)
        int nextJudgeIndex = (currentJudgeIndex + 1) % players.size();
        Player nextJudge = players.get(nextJudgeIndex);

        nextJudge.setJudge(true);  // Set the next judge

        // Notify the new judge only (not all players)
        notificationService.notify(nextJudge.getName() + " is the new judge.");

        // You can also call a method to update the game state or player observers here if needed
        return nextJudge;
    }



}
