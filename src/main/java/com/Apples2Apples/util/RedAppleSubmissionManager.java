package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RedAppleSubmissionManager {
    private final List<Card> submissions = new ArrayList<>();

    public List<Card> collectSubmissions(List<Player> players) {
        submissions.clear();  // Clear any existing submissions
        for (Player player : players) {
            if (!player.isJudge()) {
                Card chosenCard = player.chooseRedAppleCard();
                submissions.add(chosenCard);
                player.removeCard(chosenCard);
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

