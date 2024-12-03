package com.Apples2Apples.util;

import com.Apples2Apples.card.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardUtil {

    // Shuffle a list of cards
    public static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    // Apply Apples and Pears decorator to a card
    public static Card applyApplesAndPearsCard(Card card) {
        return new ApplesAndPearsCard(card);
    }

    // Apply Wild Red Apple card decorator
    public static Card applyWildRedAppleCard(Card card) {
        return new WildRedAppleCard(card);
    }

    // Load cards from a file into a List of Cards
//    public static List<Card> loadCardsFromFile(String filename) {
//        List<Card> cards = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Logic to determine the type of card based on the value read from the file
//                // For example, we could check if the line starts with certain keywords
//                if (line.startsWith("GreenApple")) {
//                    cards.add(new GreenAppleCard(line)); // Create a GreenAppleCard if it starts with "GreenApple"
//                } else if (line.startsWith("RedApple")) {
//                    cards.add(new RedAppleCard(line)); // Create a RedAppleCard if it starts with "RedApple"
//                } else {
//                    // If it's a generic card, create a base Card (can be adjusted for your needs)
//                    cards.add(new Card(line) {
//                        @Override
//                        public String getDescription() {
//                            return "This is a card with value: " + value;
//                        }
//                    });
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("IOException: " + e); // Handle file reading errors
//        }
//        return cards;
//    }
    public static List<Card> loadCardsFromFile(String fileName) {
        List<Card> cards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("GreenApple")) {
                    cards.add(new GreenAppleCard(line));
                } else if (line.startsWith("RedApple")) {
                    cards.add(new RedAppleCard(line));
                } else {
                    cards.add(new Card(line) { // Example of a generic Card
                        @Override
                        public String getDescription() {
                            return "Generic card with value: " + value;
                        }
                    });
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading cards from file: " + e.getMessage());
        }
        return cards;
    }


}
