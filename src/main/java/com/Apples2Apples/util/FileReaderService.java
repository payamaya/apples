package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.CardType;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
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

    // New methods to parse green and red apples into Card objects
    public static List<Card> readGreenApples(String filePath) {
        List<Card> cards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            cards.add(new GreenAppleCard(line)); // Assuming Card.Type.GREEN exists
        }
        return cards;
    }

    public static List<Card> readRedApples(String filePath) {
        List<Card> cards = new ArrayList<>();
        List<String> lines = readLines(filePath);
        for (String line : lines) {
            cards.add(new RedAppleCard(line)); // Assuming Card.Type.RED exists
        }
        return cards;
    }
}
