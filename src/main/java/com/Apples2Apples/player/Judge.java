package com.Apples2Apples.player;

import com.Apples2Apples.card.Card;

import java.util.List;

public interface Judge extends Player{
    Card selectFavoriteRedApple(List<Card> submissions);
}
