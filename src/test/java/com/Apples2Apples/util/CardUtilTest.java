package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardUtilTest {
    @Test
    public void testLoadGreenApples() throws IOException {
        Path tempFile = Files.createTempFile("greenApples", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Crisp\nJuicy\nFresh");
        }
        List<Card> greenApplesples = CardUtil.createGreenApplesFromFile(tempFile.toString());
        assertEquals(3, greenApplesples.size());
        assertTrue(greenApplesples.get(0) instanceof GreenAppleCard);
        assertEquals("Crisp", greenApplesples.get(0).getValue());

    }
    @Test
    public void testLoadRedApples() throws IOException {
        Path tempFile = Files.createTempFile("redApples", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("Apple\nBanana\nCherry");
        }

        List<Card> redApples = CardUtil.createRedApplesFromFile(tempFile.toString());
        assertEquals(3, redApples.size());
        assertTrue(redApples.get(0) instanceof RedAppleCard);
        assertEquals("Apple", redApples.get(0).getValue());
    }
}