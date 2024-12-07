package com.Apples2Apples.util;

import com.Apples2Apples.card.*;

import java.util.List;

/**
 * The CardUtil class provides utility methods for creating card objects from files.
 * It includes methods for creating green and red apple cards from external files.
 */
public class CardUtil {
    /**
     * Creates a list of GreenAppleCard objects by reading card data from the specified file.
     *
     * @param filePath The path to the file containing green apple card data.
     * @return A list of GreenAppleCard objects.
     */
    public static List<Card> createGreenApplesFromFile(String filePath) {
        return FileReaderService.readGreenApples(filePath);
    }
    /**
     * Creates a list of RedAppleCard objects by reading card data from the specified file.
     *
     * @param filePath The path to the file containing red apple card data.
     * @return A list of RedAppleCard objects.
     */
    public static List<Card> createRedApplesFromFile(String filePath) {
        return FileReaderService.readRedApples(filePath);
    }
}
