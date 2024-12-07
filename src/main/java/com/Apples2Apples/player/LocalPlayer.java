//package com.Apples2Apples.player;
//
//import com.Apples2Apples.card.Card;
//import java.util.Scanner;
//
//import java.util.List;
//
//public class LocalPlayer extends AbstractPlayer {
//    private boolean isJudge;
//
//    public LocalPlayer(String name, List<Card> hand, boolean canSeeCards) {
//        super(name, hand, canSeeCards);
//        this.isJudge = false;
//    }
//
//    @Override
//    public boolean hasSubmitted(Card card) {
//        return false;
//    }
//
//    @Override
//    public List<Card> getHand() {
//        return List.of();
//    }
//
//    @Override
//    public void setHand(List<Card> cards) {
//
//    }
//
//    @Override
//    public void setJudge(boolean isJudge) {
//        this.isJudge = isJudge;
//    }
//
//    @Override
//    public boolean isJudge() {
//        return this.isJudge;
//    }
//
//    @Override
//    public Card selectFavoriteRedApple(List<Card> submissions) {
//        return chooseRedAppleCard();
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
//    public Card chooseRedAppleCard() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Choose a card from your hand:");
//        for (int i = 0; i < hand.size(); i++) {
//            System.out.println(i + ": " + hand.get(i));
//        }
//        return hand.get(scanner.nextInt());
//    }
//
//
//}
