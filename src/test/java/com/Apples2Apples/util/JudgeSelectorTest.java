package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.BotPlayer;
import com.Apples2Apples.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeSelectorTest {
    private List<Player> players;
    private JudgeSelector judgeSelector;
    private GameNotification gameNotification;
    private List<Card> cards;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            // Provide an empty list of cards as required by BotPlayer constructor
            players.add(new BotPlayer("BotPlayer" + i, cards, true));
        }

        gameNotification = new GameNotification(); // Real object
        judgeSelector = new JudgeSelector(gameNotification);
    }

    @Test
    void testRandomJudgeSelectionAndNotification() {
        HashSet<Player> selectedJudges = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Player judge = judgeSelector.selectAndNotifyRandomJudge(players);
            assertNotNull(judge, "Judge should not be null.");
            assertTrue(players.contains(judge), "Selected judge must be from the players list.");
            selectedJudges.add(judge);

            // Ensure the notification message matches the expected format
            assertEquals(judge.getName() + " is the new judge.", gameNotification.getMessage(),
                    "Notification message should match the selected judge.");
        }

        // Ensure all players are selected at least once in 100 trials
        assertEquals(players.size(), selectedJudges.size(),
                "All players should be selected at least once over multiple runs.");
    }

    @Test
    void testSinglePlayer() {
        List<Player> singlePlayer = List.of(new BotPlayer("SoloPlayer", cards, true));
        Player judge = judgeSelector.selectAndNotifyRandomJudge(singlePlayer);

        // Ensure that the only player is selected as the judge
        assertEquals("SoloPlayer", judge.getName(), "The only player should be selected as the judge.");
        assertEquals("SoloPlayer is the new judge.", gameNotification.getMessage(),
                "Notification message should match the selected judge.");
    }
}
