package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;

import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * OnlinePlayer represents a player connected to an online game.
 * It uses a socket connection for communication and implements the **Observer Pattern**.
 */
public class OnlinePlayer extends AbstractPlayer {
    private static final Logger logger = Logger.getLogger(HumanPlayer.class.getName());
    private boolean isJudge;

    private Socket socket;
    private ObjectInputStream  in;
    private ObjectOutputStream  out;

    public OnlinePlayer(String name, Socket socket) throws IOException {
        super(name);  // Call the superclass constructor with the player's name
        this.socket = socket;
        this.in = in;
        this.out = out;
  
    }
    @Override
    public Card chooseRedAppleCard() {
        Scanner scanner = new Scanner(System.in);
        logger.warning("Choose a card to play:");
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i));
        }

        int choice = -1;
        while (choice < 0 || choice >= cards.size()) {
            try {
                choice = scanner.nextInt();  // Read the player's card selection
                scanner.nextLine();  // Clear the newline character after reading an integer
                if (choice < 0 || choice >= cards.size()) {
                    logger.warning("Invalid choice. Please select a card from the list.");
                }
            } catch (InputMismatchException e) {
                logger.warning("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the invalid input from the buffer
            }
        }

        return cards.get(choice);  // Return the chosen card
    }




    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        // Let the human player choose their favorite red apple from the submissions
        Scanner scanner = new Scanner(System.in);
        logger.warning("Select your favorite red apple from the following submissions:");

        for (int i = 0; i < submissions.size(); i++) {
            logger.info(i + ": " + submissions.get(i));
        }

        int choice = scanner.nextInt();
        return submissions.get(choice);
    }


    @Override
    public boolean canSeeCards() {
        return false;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {

    }

    @Override
    public void update(String message) {

    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
        if (isJudge) {
            System.out.println(getName() + " is now the judge.");
        } else {
            logger.info(getName() + " is no longer the judge.");
        }
    }

    @Override
    public boolean isJudge() {
        return false;
    }
}

