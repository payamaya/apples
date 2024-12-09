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
    private int score = 0;

    public HumanPlayer(String name) {
        super(name);
        this.isJudge = isJudge;
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
            System.out.println("Choose a red apple card (enter the card number):");
            int index = Integer.parseInt(scanner.nextLine().trim());
            if (index < 0 || index >= getHand().size()) {
                throw new CustomExceptions.InvalidUserInputException(String.valueOf(index),
                        "Please select a number between 0 and " + (getHand().size() - 1) + ".");
            }
            return getHand().get(index);
        } catch (NumberFormatException e) {
            throw new CustomExceptions.InvalidUserInputException("non-numeric input",
                    "Input must be a valid number. Example: 0, 1, or 2.");
        }
    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        // Let the human player choose their favorite red apple from the submissions
        Scanner scanner = new Scanner(System.in);

        // Remove the log here, as it's already logged in `chooseRedAppleCard()`
        int choice = scanner.nextInt();
        try {
            if (choice < 0 || choice >= submissions.size()) {
                throw new CustomExceptions.InvalidUserInputException("Invalid choice. Please select a card from the list.", "Please select a number between 0 and " + (getHand().size() - 1) + ".");
            }
        } catch (InputMismatchException e) {
            throw new CustomExceptions.InvalidUserInputException("Invalid input. Please enter a number.", "Please select a number between 0 and " + (getHand().size() - 1) + ".");
        }
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
            System.out.println(getName() + " is now the judge.");
            // Do not notify other players here, just set the judge for this player
        } else {
            logger.info(getName() + " is no longer the judge.");
        }
    }


    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void incrementScore() {
        score++;  // Increment score
        System.out.println(getName() + "'s score is now: " + score);
    }


    @Override
    public boolean isJudge() {
        return isJudge;
    }
}

