package com.Apples2Apples.util;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.card.GreenAppleCard;
import com.Apples2Apples.card.RedAppleCard;
import com.Apples2Apples.exception.CustomExceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileDAO handles the reading of game data from external files.
 */
public class FileDAO {

    /**
     * Reads card data from a file and returns it as a list of GreenAppleCard objects.
     *
     * @param filePath Path to the green apple file.
     * @return A list of GreenAppleCard objects.
     */
    public static List<Card> readGreenAppleCards(String filePath) {
        return readCards(filePath, true);
    }

    /**
     * Reads card data from a file and returns it as a list of RedAppleCard objects.
     *
     * @param filePath Path to the red apple file.
     * @return A list of RedAppleCard objects.
     */
    public static List<Card> readRedAppleCards(String filePath) {
        return readCards(filePath, false);
    }

    /**
     * Reads card data from a file and creates either GreenAppleCard or RedAppleCard objects.
     *
     * @param filePath Path to the card file.
     * @param isGreen  If true, create GreenAppleCard; otherwise, create RedAppleCard.
     * @return A list of Card objects.
     */
    private static List<Card> readCards(String filePath, boolean isGreen) {
        List<Card> cards = new ArrayList<>();
        try (InputStream inputStream = FileDAO.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found in classpath: " + filePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (isGreen) {
                        cards.add(new GreenAppleCard(line.trim()));
                    } else {
                        cards.add(new RedAppleCard(line.trim()));
                    }
                }
            }
        } catch (IOException e) {
            throw new CustomExceptions.FileDAOException("Error reading file: " + filePath, e);
        }
        return cards;
    }

}
