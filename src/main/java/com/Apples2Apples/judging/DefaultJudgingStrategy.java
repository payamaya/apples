package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Player;

import java.util.List;

public class DefaultJudgingStrategy implements JudgingStrategy {
    @Override
    public Card selectFavorite(List<Card> redAppleSubmissions, Player judge) {
        return judge.selectFavoriteRedApple(redAppleSubmissions); // Delegate to judge's choice logic
    }
}
