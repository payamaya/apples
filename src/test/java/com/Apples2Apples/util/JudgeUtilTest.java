package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.exception.CustomExceptions;
import com.Apples2Apples.observer.GameNotification;
import com.Apples2Apples.observer.GameObserver;
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
    private List<Card> cards;


    @BeforeEach
    void setUp() {
        greenApplesDeck = new ArrayList<>();
        greenApplesDeck.add(new GreenAppleCard("Sour"));
        greenApplesDeck.add(new GreenAppleCard("Fresh"));

        gameNotification = new GameNotification();
        // Provide an empty list of cards as required by BotPlayer constructor
        Player judge = new BotPlayer("JudgeBot", cards, true);
        gameNotification.addObserver((GameObserver) judge);
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
        assertThrows(CustomExceptions.JudgeUtilException.class, () -> JudgeUtil.drawGreenApple(greenApplesDeck, gameNotification));
    }
}
