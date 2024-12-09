//package com.Apples2Apples.player;
//
//import com.Apples2Apples.card.Card;
//import com.Apples2Apples.exception.CustomExceptions;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PlayerFactoryTest {
//
//    @Test
//    void testCreateLocalPlayer() {
//        String name = "LocalPlayer1";
//        List<Card> cards = new ArrayList<>();
//        Player localPlayer = PlayerFactory.createPlayer(PlayerType.LOCAL, name, cards, false);
//
//        assertNotNull(localPlayer);
//        assertTrue(localPlayer instanceof HumanPlayer);
//        assertEquals(name, localPlayer.getName());
//        assertFalse(localPlayer.isJudge());
//    }
//
//    @Test
//    void testCreateOnlinePlayer() {
//        String name = "OnlinePlayer1";
//        List<Card> cards = new ArrayList<>();
//
//        try {
//            Player onlinePlayer = PlayerFactory.createPlayer(PlayerType.ONLINE, name, cards, false);
//            assertNotNull(onlinePlayer);
//            assertTrue(onlinePlayer instanceof OnlinePlayer);
//            assertEquals(name, onlinePlayer.getName());
//        } catch (CustomExceptions.OnlineCommunicationException e) {
//            // Handle network exceptions during test if the socket fails.
//            fail("Exception thrown during online player creation: " + e.getMessage());
//        }
//    }
//
//    @Test
//    void testCreateBotPlayer() {
//        String name = "BotPlayer1";
//        List<Card> cards = new ArrayList<>();
//        Player botPlayer = PlayerFactory.createPlayer(PlayerType.BOT, name, cards, true);
//
//        assertNotNull(botPlayer);
//        assertTrue(botPlayer instanceof BotPlayer);
//        assertEquals(name, botPlayer.getName());
//        assertTrue(botPlayer.isJudge());
//    }
//
//    @Test
//    void testUnknownPlayerTypeThrowsException() {
//        String name = "UnknownPlayer";
//        List<Card> cards = new ArrayList<>();
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->
//                PlayerFactory.createPlayer(null, name, cards, false));
//
//        assertEquals("Unknown player type: null", exception.getMessage());
//    }
//}
