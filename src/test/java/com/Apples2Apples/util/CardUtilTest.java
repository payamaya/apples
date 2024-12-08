package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardUtilTest {

    @Test
    public void testLoadGreenApples() throws IOException {
        // Test file path within the test/resources folder (assuming it exists)
        String testFilePath = "greenApples.txt";

        List<Card> greenApples = CardUtil.createGreenApplesFromFile(testFilePath);
        assertEquals(3, greenApples.size(), "Incorrect number of green apple cards"); // Adjust expected count as needed

        assertTrue(greenApples.get(0) instanceof GreenAppleCard, "Card is not a GreenAppleCard");
        assertEquals("Crisp", greenApples.get(0).getValue(), "Incorrect GreenAppleCard value");
    }

    @Test
    public void testLoadRedApples() throws IOException {
        // Test file path within the test/resources folder (assuming it exists)
        String testFilePath = "redApples.txt";

        List<Card> redApples = CardUtil.createRedApplesFromFile(testFilePath);
        assertEquals(3, redApples.size(), "Incorrect number of red apple cards"); // Adjust expected count as needed

        assertTrue(redApples.get(0) instanceof RedAppleCard, "Card is not a RedAppleCard");
        assertEquals("Apple Pie", redApples.get(0).getValue(), "Incorrect RedAppleCard value");
    }
}