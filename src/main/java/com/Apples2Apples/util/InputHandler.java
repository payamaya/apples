package com.Apples2Apples.util;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getPlayerInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().toUpperCase();
    }
}
