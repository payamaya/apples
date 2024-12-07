package com.Apples2Apples.judging;


import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;

import java.util.List;

public class DefaultJudgingStrategy implements JudgingStrategy {
    @Override
    public Card selectFavorite(List<Card> redAppleSubmissions, Judge judge) {
        return judge.selectFavoriteRedApple(redAppleSubmissions); // Delegate to Judge
    }
}
