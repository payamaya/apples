package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;
import com.Apples2Apples.player.Player;
import java.util.List;

public class JudgeManager {
    private final JudgingStrategy judgingStrategy;
    private final NotificationService notificationService;

    public JudgeManager(JudgingStrategy judgingStrategy, NotificationService notificationService) {
        this.judgingStrategy = judgingStrategy;
        this.notificationService = notificationService;
    }

    public void selectWinner(List<Card> redAppleSubmissions, Judge judge, List<Player> players) {
        if (redAppleSubmissions.isEmpty()) {
            notificationService.notify("No red apple submissions available.");
            return;
        }

        Card favoriteRedApple = judge.selectFavoriteRedApple(redAppleSubmissions);
        notificationService.notify("Judge selected: " + favoriteRedApple);

        Player winningPlayer = findPlayerWhoSubmitted(favoriteRedApple, players);
        if (winningPlayer != null) {
            winningPlayer.incrementScore();
            notificationService.notify(winningPlayer.getName() + " wins this round!");
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

    public Player rotateJudge(List<Player> players, Player currentJudge) {
        // Find current judge's index
        int currentJudgeIndex = players.indexOf(currentJudge);

        // Make the current judge no longer the judge
        currentJudge.setJudge(false);

        // Find the next player (next in the list, loop back to the first if we are at the end)
        int nextJudgeIndex = (currentJudgeIndex + 1) % players.size();
        Player nextJudge = players.get(nextJudgeIndex);

        // Set the next player as the new judge
        nextJudge.setJudge(true);

        // Notify that the judge has rotated
        notificationService.notify(nextJudge.getName() + " is the new judge.");
        return nextJudge;
    }


}
