package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Player;

import java.util.List;

public class JudgeManager {
    private final JudgingStrategy judgingStrategy;
    private final NotificationService notificationService;

    public JudgeManager(JudgingStrategy judgingStrategy, NotificationService notificationService) {
        this.judgingStrategy = judgingStrategy;
        this.notificationService = notificationService;
    }

    /**
     * Rotates the judge to the next player.
     *
     * @param players       List of players in the game.
     * @param currentJudge  The current judge.
     * @return The next judge.
     */
    public Player rotateJudge(List<Player> players, Player currentJudge) {
        int currentIndex = players.indexOf(currentJudge);
        int nextIndex = (currentIndex + 1) % players.size();

        // Update the judge status
        currentJudge.setJudge(false);
        Player nextJudge = players.get(nextIndex);
        nextJudge.setJudge(true);

        // Notify players about the new judge
        notifyPlayers(nextJudge.getName() + " is the new judge.");
        return nextJudge;
    }

    /**
     * Selects the winner for the current round based on the judge's choice of favorite card.
     *
     * @param redAppleSubmissions List of submitted red apple cards.
     * @param judge               The judge selecting the winner.
     * @param players             List of players in the game.
     */
    public void selectWinner(List<Card> redAppleSubmissions, Player judge, List<Player> players) {
        if (redAppleSubmissions == null || redAppleSubmissions.isEmpty()) {
            notificationService.notify("No red apple submissions available.");
            return;
        }

        // Judge selects their favorite red apple card
        Card favoriteRedApple = judge.selectFavoriteRedApple(redAppleSubmissions);

        if (favoriteRedApple == null) {
            notificationService.notify("Favorite red apple selection failed.");
            return;
        }

        notificationService.notify(judge.getName() + " selected: " + favoriteRedApple.getValue());

        // Identify the player who submitted the favorite card
        Player winningPlayer = findPlayerWhoSubmitted(favoriteRedApple, players);

        if (winningPlayer != null) {
            winningPlayer.addGreenApple();
            notificationService.notify(winningPlayer.getName() + " wins a green apple!");
        } else {
            notificationService.notify("No valid winner found for this round.");
        }
    }

    /**
     * Finds the player who submitted a specific red apple card.
     *
     * @param card    The card to search for.
     * @param players List of players.
     * @return The player who submitted the card, or null if not found.
     */
    private Player findPlayerWhoSubmitted(Card card, List<Player> players) {
        for (Player player : players) {
            if (!player.isJudge() && player.hasSubmitted(card)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Notifies all players with the given message.
     *
     * @param message The message to send.
     */
    private void notifyPlayers(String message) {
        notificationService.notify(message);
    }
}
