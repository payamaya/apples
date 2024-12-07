package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

public interface Judgeable {
    Card selectFavoriteRedApple(List<Card> submissions);
    void setJudge(boolean isJudge);
    boolean isJudge();
}