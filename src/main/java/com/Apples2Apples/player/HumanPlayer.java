package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class HumanPlayer extends AbstractPlayer implements Judge {
    private static final Logger logger = Logger.getLogger(HumanPlayer.class.getName());
    private boolean isJudge;

    public HumanPlayer(String name) {
        super(name);
        this.isJudge = false;
    }

    @Override
    public Card chooseRedAppleCard() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Choose a card to play:");
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            logger.info(i + ": " + cards.get(i));
        }
        int choice = scanner.nextInt();
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
        return submissions.get(choice);
    }


    @Override
    public Card selectRedApple() {
        return null;  // Human players don't participate in this phase
    }

    @Override
    public void update(String message) {}

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

