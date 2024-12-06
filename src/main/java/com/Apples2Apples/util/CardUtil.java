package com.Apples2Apples.util;

import com.Apples2Apples.card.*;

import java.util.List;


public class CardUtil {

    public static List<Card> createGreenApplesFromFile(String filePath) {
        return FileReaderService.readGreenApples(filePath);
    }

    public static List<Card> createRedApplesFromFile(String filePath) {
        return FileReaderService.readRedApples(filePath);
    }
}
