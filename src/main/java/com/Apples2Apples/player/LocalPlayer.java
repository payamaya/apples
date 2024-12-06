package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.observer.Observer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LocalPlayer extends Player implements CardChooser, Observer {

    public LocalPlayer(String name, boolean canSeeCards) {
        super(name);
        this.setCanSeeCards(canSeeCards);
    }

    @Override
    public Card selectRedApple() {
        List<Card> cards = handManager.getCards();  // Use HandManager
        if (cards.isEmpty()) {
            System.out.println(name + " has no cards to choose from.");
            return null;
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > cards.size()) {
            try {
                System.out.println(name + ", choose a red apple (1-" + cards.size() + "): ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > cards.size()) {
                    System.out.println("Invalid choice. Please select a valid card.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        return cards.get(choice - 1);  // Adjust for 0-based index
    }

    @Override
    public Card chooseCard() {
        return selectRedApple();  // Use selectRedApple directly
    }

    @Override
    public Card chooseRedAppleCard() {
        return null;  // If this is intentionally unused, it can remain null
    }

    @Override
    public void removeCard(Card chosenCard) {
        if (chosenCard == null) {
            System.out.println("Error: Chosen card is null.");
            return;
        }

        if (handManager.getCards().contains(chosenCard)) {
            handManager.removeCard(chosenCard);  // Use HandManager
            System.out.println(name + " has removed the card: " + chosenCard);
        } else {
            System.out.println("The card does not exist in " + name + "'s hand: " + chosenCard);
        }
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> redAppleSubmissions) {
        return null;  // Implement this if needed
    }

    @Override
    public boolean hasSubmitted(Card favoriteRedApple) {
        return handManager.getCards().contains(favoriteRedApple);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}
