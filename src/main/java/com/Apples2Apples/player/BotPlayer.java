package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BotPlayer extends Player  {

    public BotPlayer(String name, boolean canSeeCards) {
        super(name);
        this.setCanSeeCards(canSeeCards);
    }

    @Override
    public Card chooseRedAppleCard() {
        Random random = new Random();
        List<Card> cards = handManager.getCards(); 
        if (cards.isEmpty()) {
            System.out.println(name + " has no cards to choose from.");
            return null;
        }
        Card chosenCard = cards.get(random.nextInt(cards.size()));
        handManager.removeCard(chosenCard);  // Remove the chosen card from hand
        return chosenCard;
    }

    @Override
    public Card chooseCard() {
        return chooseRedAppleCard();  // Delegate to the random chooser logic
    }

//    @Override
//    public Card selectRedApple() {
//        List<Card> cards = handManager.getCards();  // Use HandManager
//        if (cards.isEmpty()) {
//            System.out.println(name + " has no cards to choose from.");
//            return null;
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        int choice = -1;
//
//        while (choice < 1 || choice > cards.size()) {
//            try {
//                System.out.println(name + ", choose a red apple (1-" + cards.size() + "): ");
//                choice = scanner.nextInt();
//
//                if (choice < 1 || choice > cards.size()) {
//                    System.out.println("Invalid choice. Please select a valid card.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a number.");
//                scanner.next(); // Clear invalid input
//            }
//        }
//
//        return cards.get(choice - 1);  // Adjust for 0-based index
//    }
@Override
public Card selectRedApple() {
    List<Card> cards = handManager.getCards();  // Use HandManager
    if (cards.isEmpty()) {
        System.out.println(name + " has no cards to choose from.");
        return null;
    }
    Random random = new Random();
    return cards.get(random.nextInt(cards.size()));  // Randomly choose a card
}

    @Override
    public Card selectFavoriteRedApple(List<Card> redAppleCards) {
        if (redAppleCards == null || redAppleCards.isEmpty()) {
            System.out.println("No red apple cards to choose from.");
            return null;
        }

        Random random = new Random();
        return redAppleCards.get(random.nextInt(redAppleCards.size()));
    }

    @Override
    public void removeCard(Card chosenCard) {
        if (chosenCard == null) {
            System.out.println("Error: Chosen card is null.");
            return;
        }

        handManager.removeCard(chosenCard);  // Use HandManager
        System.out.println(name + " has removed the card: " + chosenCard);
    }

    @Override
    public boolean hasSubmitted(Card favoriteRedApple) {
        return handManager.getCards().contains(favoriteRedApple);
    }

}
