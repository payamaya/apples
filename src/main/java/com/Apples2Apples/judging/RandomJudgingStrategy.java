package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;


import java.util.List;
import java.util.Random;

public class RandomJudgingStrategy implements JudgingStrategy {
    @Override
    public Card selectFavorite(List<Card> redAppleSubmissions, Judge judge) {
        Random random = new Random();
        return redAppleSubmissions.get(random.nextInt(redAppleSubmissions.size()));
    }
}
