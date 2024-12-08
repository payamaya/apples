package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileDAOTest {

    private FileDAO fileDAO;

    @BeforeEach
    void setUp() {
        fileDAO = new FileDAO();
    }

    @Test
    void testReadGreenAppleCards() {
        String testFilePath = "greenApples.txt"; // File should be placed in src/test/resources folder
        List<Card> greenAppleCards = fileDAO.readGreenAppleCards(testFilePath);

        // Assuming the test file has 3 lines representing 3 GreenAppleCard objects
        int expectedCount = 3; // Example value, change it based on the actual test file
        assertEquals(expectedCount, greenAppleCards.size(), "The number of green apple cards should match.");

        // Further verify that the objects are actually instances of GreenAppleCard
        for (Card card : greenAppleCards) {
            assertTrue(card instanceof GreenAppleCard, "Each card should be a GreenAppleCard");
        }
    }

    @Test
    void testReadRedAppleCards() {
        String testFilePath = "redApples.txt"; // File should be placed in src/test/resources folder
        List<Card> redAppleCards = fileDAO.readRedAppleCards(testFilePath);

        // Assuming the test file has 3 lines representing 3 RedAppleCard objects
        int expectedCount = 3; // Example value, change it based on the actual test file
        assertEquals(expectedCount, redAppleCards.size(), "The number of red apple cards should match.");

        // Further verify that the objects are actually instances of RedAppleCard
        for (Card card : redAppleCards) {
            assertTrue(card instanceof RedAppleCard, "Each card should be a RedAppleCard");
        }
    }
}
