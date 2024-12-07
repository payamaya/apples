package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.CardType;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * The FileReaderService class provides methods to read lines from a file and parse them
 * into card objects (both red and green apples) for the Apples to Apples game.
 */
public class FileReaderService {

    /**
     * Reads all lines from a file and returns them as a list of strings.
     *
     * @param filePath The path to the file.
     * @return A list of strings representing each line in the file.
     */
    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
        return lines;
    }

    /**
     * Reads green apple cards from a file and returns a list of GreenAppleCard objects.
     *
     * @param filePath The path to the file containing green apple card data.
     * @return A list of GreenAppleCard objects.
     */
    public static List<Card> readGreenApples(String filePath) {
        List<Card> cards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            cards.add(new GreenAppleCard(line)); // Assuming Card.Type.GREEN exists
        }
        return cards;
    }
    /**
     * Reads red apple cards from a file and returns a list of RedAppleCard objects.
     *
     * @param filePath The path to the file containing red apple card data.
     * @return A list of RedAppleCard objects.
     */
    public static List<Card> readRedApples(String filePath) {
        List<Card> cards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            cards.add(new RedAppleCard(line)); // Assuming Card.Type.RED exists
        }
        return cards;
    }
}
