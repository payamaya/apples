package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.player.Player;
import com.Apples2Apples.player.BotPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeUtilTest {
    private List<Card> greenApplesDeck;
    private GameNotification gameNotification;

    @BeforeEach
    void setUp() {
        greenApplesDeck = new ArrayList<>();
        greenApplesDeck.add(new GreenAppleCard("Sour"));
        greenApplesDeck.add(new GreenAppleCard("Fresh"));

        gameNotification = new GameNotification();
        Player judge = new BotPlayer("JudgeBot", true);
        gameNotification.addObserver(judge);
    }

    @Test
    void testDrawGreenApple() {
        Card drawnCard = JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification);
        assertNotNull(drawnCard);
        assertEquals("Sour", drawnCard.getValue());
        assertEquals(1, greenApplesDeck.size());
    }

    @Test
    void testDrawGreenAppleEmptyDeck() {
        greenApplesDeck.clear();
        Card drawnCard = JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification);
        assertNull(drawnCard);
    }
}
