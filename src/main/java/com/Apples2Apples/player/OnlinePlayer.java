package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OnlinePlayer extends Player implements CardChooser {

    private Socket socket;

    public OnlinePlayer(String name, Socket socket, boolean canSeeCards) {
        super(name);
        this.socket = socket;
        this.setCanSeeCards(canSeeCards); // Ensure canSeeCards is set
    }
    @Override
    public Card selectRedApple() {
        if (handManager.getCards().isEmpty()) {
            System.out.println(name + " has no cards to choose from.");
            return null; // Or handle this case differently depending on your game logic
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        int handSize = handManager.getCards().size(); // Get the size of the hand

        while (choice < 1 || choice > handSize) {
            try {
                System.out.println(name + ", choose a red apple (1-" + handSize + "): ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > handSize) {
                    System.out.println("Invalid choice. Please select a valid card.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Ensure we are returning a valid card from the hand
        Card selectedCard = handManager.getCards().get(choice - 1);
        return selectedCard != null ? selectedCard : null; // Return null if the card is null
    }



    @Override
    public Card chooseCard() {
        if (handManager.getCards().isEmpty()) {
            System.out.println(name + " has no cards to choose from.");
            return null; // Or handle this case differently
        }
        Card selectedCard = selectRedApple();  // Should return a valid card
        if (selectedCard == null) {
            System.out.println("Error: selectRedApple returned null.");
        }
        return selectRedApple(); // This should return a valid card
    }

    @Override
    public Card chooseRedAppleCard() {
        return null;
    }

    @Override
    public void removeCard(Card chosenCard) {
        if (chosenCard == null) {
            System.out.println("Error: Chosen card is null.");
            return;
        }

        if (handManager.getCards().contains(chosenCard)) { // Use handManager here
            handManager.removeCard(chosenCard);            // Remove card using handManager
            System.out.println(name + " has removed the card: " + chosenCard);
        } else {
            System.out.println("The card does not exist in " + name + "'s hand: " + chosenCard);
        }
    }



    @Override
    public Card selectFavoriteRedApple(List<Card> redAppleSubmissions) {
        return null;
    }

    @Override
    public boolean hasSubmitted(Card favoriteRedApple) {
        return false;
    }

    public Socket getSocket() {
        return socket;
    }


    public void update(String message) {
        System.out.println("Update for " + getName() + ": " + message);
    }
}
