package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

public interface CardChooser {
    Card selectFavoriteRedApple(List<Card> submissions);
    Card selectRedApple();
}
