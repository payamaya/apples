package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Player;

import java.util.List;

public interface JudgingStrategy {
    Card selectFavorite(List<Card> redAppleSubmissions, Player judge);
}
