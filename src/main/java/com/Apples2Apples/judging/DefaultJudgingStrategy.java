package com.Apples2Apples.judging;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;

import java.util.List;

/**
 * The {@code DefaultJudgingStrategy} class provides a default implementation
 * of the {@link JudgingStrategy} interface. It delegates the responsibility
 * of selecting the favorite card to the {@link Judge}.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Implements the judging logic defined in the {@code JudgingStrategy} interface.</li>
 *   <li>Utilizes the judge's built-in logic for selecting the favorite card.</li>
 * </ul>
 *
 * <h2>Design Pattern</h2>
 * <p>This class is part of the Strategy Pattern, providing a default judging
 * mechanism while allowing for future customization.</p>
 */
public class DefaultJudgingStrategy implements JudgingStrategy {
    /**
     * Delegates the selection of the favorite card to the judge.
     *
     * @param redAppleSubmissions the list of submitted red apple cards.
     * @param judge               the judge responsible for selecting the favorite card.
     * @return the card selected as the favorite.
     */
    @Override
    public Card selectFavorite(List<Card> redAppleSubmissions, Judge judge) {
        return judge.selectFavoriteRedApple(redAppleSubmissions); // Delegate to Judge
    }
}
