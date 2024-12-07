//package com.Apples2Apples.player;
//
//import com.Apples2Apples.card.Card;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//public class HumanPlayer extends AbstractPlayer {
//    private String name;
//    private List<Card> hand = new ArrayList<>();
//    private int score = 0;
//    private boolean canSeeCards = true;
//
//    public HumanPlayer(String name, List<Card> hand, boolean canSeeCards) {
//        super(name, hand, canSeeCards);
//    }
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public boolean canSeeCards() {
//        return canSeeCards;
//    }
//
//    @Override
//    public void setCanSeeCards(boolean canSeeCards) {
//        this.canSeeCards = canSeeCards;
//    }
//
//    @Override
//    public Card chooseRedAppleCard() {
//        System.out.println("Choose a card to play:");
//        for (int i = 0; i < hand.size(); i++) {
//            System.out.println(i + ": " + hand.get(i));
//        }
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//        Card chosenCard = hand.get(choice);
//        removeCard(chosenCard);
//        return chosenCard;
//    }
//
//    @Override
//    public void removeCard(Card chosenCard) {
//
//    }
//
//    @Override
//    public Card selectRedApple() {
//        return null;
//    }
//
//    @Override
//    public void update(String message) {
//
//    }
//
//    @Override
//    public void addCard(Card card) {
//
//    }
//
//    @Override
//    public Card selectFavoriteRedApple(List<Card> submissions) {
//        return getRandomCard(submissions);
//    }
//
////    @Override
////    public void receiveCard(Card card) {
////        hand.add(card);
////    }
//
//    @Override
//    public int getScore() {
//        return score;
//    }
//
//    @Override
//    public void incrementScore() {
//        score++;
//    }
//
//    @Override
//    public boolean hasSubmitted(Card card) {
//        return hand.contains(card);
//    }
//
//    @Override
//    public List<Card> getHand() {
//        return hand;
//    }
//
//    @Override
//    public void setHand(List<Card> cards) {
//        this.hand = cards;
//    }
//
//    @Override
//    public boolean isJudge() {
//        return false;
//    }
//
//    public Card getRandomCard(List<Card> cards) {
//        if (cards == null || cards.isEmpty()) {
//            return null;
//        }
//        Random random = new Random();
//        return cards.get(random.nextInt(cards.size()));
//    }
//}
package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Card chooseRedAppleCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a card to play:");
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i));
        }
        int choice = scanner.nextInt();
        return cards.get(choice);
    }

    @Override
    public boolean canSeeCards() {
        return false;
    }

    @Override
    public void setCanSeeCards(boolean canSeeCards) {

    }

    @Override
    public Card selectFavoriteRedApple(List<Card> submissions) {
        return null;
    }

    @Override
    public Card selectRedApple() {
        return null;
    }

    @Override
    public void update(String message) {

    }

    @Override
    public void setJudge(boolean b) {

    }

    @Override
    public boolean isJudge() {
        return false;
    }
}
