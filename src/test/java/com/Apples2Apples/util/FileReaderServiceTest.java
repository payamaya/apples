package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderServiceTest {

    private File greenAppleFile;
    private File redAppleFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create temporary files for testing
        greenAppleFile = File.createTempFile("greenApples", ".txt");
        redAppleFile = File.createTempFile("redApples", ".txt");

        // Write test data to the files
        try (FileWriter writer = new FileWriter(greenAppleFile)) {
            writer.write("Fresh\n");
            writer.write("Sour\n");
            writer.write("Crunchy\n");
        }

        try (FileWriter writer = new FileWriter(redAppleFile)) {
            writer.write("Sweet\n");
            writer.write("Spicy\n");
            writer.write("Tart\n");
        }
    }

    @Test
    void testReadLines() {
        // Test the readLines method to ensure it reads the file correctly
        List<String> lines = FileReaderService.readLines(greenAppleFile.getAbsolutePath());

        // Verify the file content is read correctly
        assertEquals(3, lines.size(), "File should have 3 lines.");
        assertTrue(lines.contains("Fresh"));
        assertTrue(lines.contains("Sour"));
        assertTrue(lines.contains("Crunchy"));
    }

    @Test
    void testReadGreenApples() {
        // Test the readGreenApples method to ensure it creates the correct cards
        List<Card> greenAppleCards = FileReaderService.readGreenApples(greenAppleFile.getAbsolutePath());

        // Verify the size and content of the green apple cards
        assertEquals(3, greenAppleCards.size(), "There should be 3 green apple cards.");
        assertTrue(greenAppleCards.get(0) instanceof GreenAppleCard);
        assertEquals("Fresh", greenAppleCards.get(0).getValue());
        assertEquals("Sour", greenAppleCards.get(1).getValue());
        assertEquals("Crunchy", greenAppleCards.get(2).getValue());
    }

    @Test
    void testReadRedApples() {
        // Test the readRedApples method to ensure it creates the correct cards
        List<Card> redAppleCards = FileReaderService.readRedApples(redAppleFile.getAbsolutePath());

        // Verify the size and content of the red apple cards
        assertEquals(3, redAppleCards.size(), "There should be 3 red apple cards.");
        assertTrue(redAppleCards.get(0) instanceof RedAppleCard);
        assertEquals("Sweet", redAppleCards.get(0).getValue());
        assertEquals("Spicy", redAppleCards.get(1).getValue());
        assertEquals("Tart", redAppleCards.get(2).getValue());
    }

    @Test
    void testReadGreenApplesWithEmptyFile() throws IOException {
        // Test when reading from an empty file
        File emptyFile = File.createTempFile("empty", ".txt");
        List<Card> greenAppleCards = FileReaderService.readGreenApples(emptyFile.getAbsolutePath());

        // Ensure that no cards are created when the file is empty
        assertEquals(0, greenAppleCards.size(), "There should be no green apple cards in an empty file.");
    }

    @Test
    void testFileReaderServiceThrowsExceptionForInvalidFile() {
        // Test that the service throws an exception for an invalid file path
        assertThrows(RuntimeException.class, () -> {
            FileReaderService.readGreenApples("invalidFilePath.txt");
        }, "An exception should be thrown for an invalid file path.");
    }

    // Clean up temporary files after tests
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        greenAppleFile.delete();
        redAppleFile.delete();
    }
}
