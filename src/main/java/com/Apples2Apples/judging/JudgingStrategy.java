package com.Apples2Apples.judging;



import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;

import java.util.List;

public interface JudgingStrategy {
    Card selectFavorite(List<Card> redAppleSubmissions, Judge judge);
}
