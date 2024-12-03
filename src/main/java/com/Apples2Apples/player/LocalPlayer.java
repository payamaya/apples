package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;
import java.util.Scanner;

public class LocalPlayer extends Player {

    public LocalPlayer(int playerID, List<Card> hand) {
        super(playerID, hand);
    }

    @Override
    public Card selectRedApple() {
        // Allow player to choose a red apple from the hand
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", choose a red apple (1-" + hand.size() + "): ");
        int choice = scanner.nextInt();
        return hand.get(choice - 1);
    }
}
