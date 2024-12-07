//package com.Apples2Apples.player;
//
//import com.Apples2Apples.card.Card;
//
//import java.util.List;
//
//public interface Player {
//    String getName();
//    boolean canSeeCards();
//    void setCanSeeCards(boolean canSeeCards);
//   // void receiveCard(Card card);
//    int getScore();
//    void incrementScore();
//    boolean hasSubmitted(Card card);
//    List<Card> getHand();
//    void setHand(List<Card> cards);
//    void setJudge(boolean isJudge);
//    boolean isJudge();
//    Card chooseRedAppleCard();
////    Card selectFavoriteRedApple(List<Card> submissions);
//
//    default void addCard(Card card) {
//        getHand().add(card);
//    }
//
//    Card selectFavoriteRedApple(List<Card> submissions);
//
//    default void removeCard(Card card) {
//        getHand().remove(card);
//    }
//
//    Card selectRedApple();
//
//    void update(String message);
//}
//
package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

public interface Player extends Playable {
    String getName();
    boolean canSeeCards();
    void setCanSeeCards(boolean canSeeCards);
    int getScore();
    void incrementScore();
    void setHand(List<Card> cards);
    List<Card> getHand();

    Card selectFavoriteRedApple(List<Card> submissions);

    Card selectRedApple();

    void update(String message);

    void setJudge(boolean b);

    boolean isJudge();
}
