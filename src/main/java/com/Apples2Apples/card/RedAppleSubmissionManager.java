package com.Apples2Apples.card;

import com.Apples2Apples.game.Game;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.util.LoggerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages the collection, randomization, and discarding of red apple card submissions
 * during the game. Ensures that only non-judge players submit cards.
 */
public class RedAppleSubmissionManager {
    private static final LoggerUtil logger = LoggerUtil.getInstance(Game.class);
    private final List<Card> submissions = new ArrayList<>();

    public List<Card> collectSubmissions(List<Player> players) {
        submissions.clear();  // Clear any existing submissions
        for (Player player : players) {
            if (!player.isJudge()) {
                try {
                    Card chosenCard = player.chooseRedAppleCard();
                    submissions.add(chosenCard);
                    player.removeCard(chosenCard);
                } catch (Exception e) {
                    logger.error("Error collecting card from player: " + player.getName(), e);

                }
            }
        }
        Collections.shuffle(submissions);
        return submissions;
    }

    public void discardSubmissions(List<Card> submissions) {
        submissions.clear(); // Clears the list of used cards
    }

    // Implement the missing method to return submissions
    public List<Card> getSubmissions() {
        return submissions;
    }
}

