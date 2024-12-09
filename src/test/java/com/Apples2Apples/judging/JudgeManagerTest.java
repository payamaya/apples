package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.Judge;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.BotPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeManagerTest {
    private JudgeManager judgeManager;
    private GameNotification gameNotification;
    private List<Card> redAppleSubmissions;
    private Player judge;
    private List<Player> players;
    private List<Card> cards;

    @BeforeEach
    void setUp() {
        gameNotification = new GameNotification();
        NotificationService notificationService = new NotificationService(gameNotification);
        judgeManager = new JudgeManager(new DefaultJudgingStrategy(), notificationService);

        redAppleSubmissions = new ArrayList<>();
        players = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Player player = new BotPlayer("Player" + i, cards, false);
            Card card = new GreenAppleCard("Card" + i);
            player.addCard(card);
            redAppleSubmissions.add(card);
            players.add(player);
        }

        judge = new BotPlayer("JudgeBot", cards, true) {
            @Override
            public Card selectFavoriteRedApple(List<Card> submissions) {
                return submissions.get(0);  // Always select the first card.
            }
        };
    }


    @Test
    void testSelectWinnerValidSubmission() {
        // Ensure the initial score of players is zero
        assertEquals(0, players.get(0).getScore(), "Initial score should be 0.");

        // Call the method that selects the winner
        judgeManager.selectWinner(redAppleSubmissions, (Judge) judge, players);

        // Check that the score of the first player increased by 1
        assertEquals(1, players.get(0).getScore(), "Winner should receive 1 green apple.");
        System.out.println("Player 0 Score: " + players.get(0).getScore());
    }


    @Test
    void testSelectWinnerEmptySubmission() {
        redAppleSubmissions.clear();
        judgeManager.selectWinner(redAppleSubmissions, (Judge) judge, players);
        assertEquals("No red apple submissions available.", gameNotification.getMessage());
    }


    @Test
    void testRotateJudge() {
        Player initialJudge = judge;
        Player nextJudge = judgeManager.rotateJudge(players, initialJudge);

        // Verify the judge rotation
        assertEquals(players.get(0), nextJudge, "The next judge should be Player 1.");
        assertFalse(initialJudge.isJudge(), "The initial judge should no longer be the judge.");
        assertTrue(nextJudge.isJudge(), "Next judge should gain judge status.");
        assertEquals("Player0 is the new judge.", gameNotification.getMessage());  // Fix the message expectation
    }


    @Test
    void testRotateJudgeWithSinglePlayer() {
        players.clear();
        players.add(judge); // Only one player (the judge)

        Player nextJudge = judgeManager.rotateJudge(players, judge);

        // Verify that the single player remains the judge
        assertEquals(judge, nextJudge, "The judge should remain the same with a single player.");
        assertTrue(nextJudge.isJudge(), "The single player should retain judge status.");
    }
}
