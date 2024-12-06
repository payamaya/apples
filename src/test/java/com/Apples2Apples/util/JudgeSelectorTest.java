package com.Apples2Apples.util;

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

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            players.add(new BotPlayer("BotPlayer" + i, true));
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

            assertEquals(judge.getName() + " is the new judge!", gameNotification.getMessage(),
                    "Notification message should match the selected judge.");
        }

        assertEquals(players.size(), selectedJudges.size(),
                "All players should be selected at least once over multiple runs.");
    }

    @Test
    void testSinglePlayer() {
        List<Player> singlePlayer = List.of(new BotPlayer("SoloPlayer", true));
        Player judge = judgeSelector.selectAndNotifyRandomJudge(singlePlayer);

        assertEquals("SoloPlayer", judge.getName(), "The only player should be selected as the judge.");
        assertEquals("SoloPlayer is the new judge!", gameNotification.getMessage(),
                "Notification message should match the selected judge.");
    }

    @Test
    void testEmptyPlayerList() {
        List<Player> emptyList = new ArrayList<>();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> judgeSelector.selectAndNotifyRandomJudge(emptyList),
                "Should throw exception for empty player list.");

        assertEquals("Player list cannot be empty", exception.getMessage());
    }
}
