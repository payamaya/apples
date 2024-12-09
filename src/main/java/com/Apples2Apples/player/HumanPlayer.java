package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.exception.CustomExceptions;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * HumanPlayer represents a player controlled by a human. This player interacts with the game via the console to
 * select red apple cards and favorite red apples from submissions.
 * Implements **Observer Pattern** to receive updates about the game state.
 */
public class HumanPlayer extends AbstractPlayer implements Judge {
    private static final Logger logger = Logger.getLogger(HumanPlayer.class.getName());
    private boolean isJudge;

    public HumanPlayer(String name) {
        super(name);
        this.isJudge = false;
    }

    public HumanPlayer(String name, List<Card> cards, boolean isJudge) {
        super(name);
    }


    @Override
    public Card chooseRedAppleCard() {
        Scanner scanner = new Scanner(System.in);
        logger.warning("Choose a card to play:");
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i));
        }

        int choice;
        try {
            choice = scanner.nextInt();
            if (choice < 0 || choice >= cards.size()) {
                throw new CustomExceptions.InvalidUserInputException("Invalid choice. Please select a card from the list.");
            }
        } catch (InputMismatchException e) {
            throw new CustomExceptions.InvalidUserInputException("Invalid input. Please enter a number.");
        }
        return cards.get(choice);
    }


    @Override
    public boolean canSeeCards() {
        return false;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {}

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        // Let the human player choose their favorite red apple from the submissions
        Scanner scanner = new Scanner(System.in);

        logger.info("Select your favorite red apple from the following submissions:");

        for (int i = 0; i < submissions.size(); i++) {

            logger.info(i + ": " + submissions.get(i));
        }

        int choice = scanner.nextInt();
        try {
            choice = scanner.nextInt();
            if (choice < 0 || choice >= submissions.size()) {
                throw new CustomExceptions.InvalidUserInputException("Invalid choice. Please select a card from the list.");
            }
        } catch (InputMismatchException e) {
            throw new CustomExceptions.InvalidUserInputException("Invalid input. Please enter a number.");
        }
        return submissions.get(choice);
    }


    @Override
    public Card selectRedApple() {
        return null;  // Human players don't participate in this phase
    }

    @Override
    public void update(String message) {
        System.out.println(getName() + " received update: " + message);
    }

    @Override
    public void setJudge(boolean isJudge) {
        this.isJudge = isJudge;
        if (isJudge) {
            logger.info(getName() + " is now the judge.");
        } else {
            logger.info(getName() + " is no longer the judge.");
        }
    }

    @Override
    public boolean isJudge() {
        return false;
    }
}

