package com.Apples2Apples.judging;



import com.Apples2Apples.card.Card;
import com.Apples2Apples.player.Judge;

import java.util.List;

/**
 * The {@code JudgingStrategy} interface defines the contract for selecting
 * a winning red apple card from a list of submissions. This allows for
 * different judging algorithms to be implemented based on gameplay rules
 * or custom criteria.
 *
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Define the method for selecting the favorite card from submissions.</li>
 *   <li>Encourage flexibility through custom implementations.</li>
 * </ul>
 *
 * <h2>Design Pattern</h2>
 * <p>This interface is part of the Strategy Pattern, allowing the judging
 * mechanism to be decoupled from other game logic.</p>
 *
 * <h2>Method Summary</h2>
 * <ul>
 *   <li>{@link #selectFavorite(List, Judge)}: Selects the winning red apple
 *       card based on the given judge and submissions.</li>
 * </ul>
 */
public interface JudgingStrategy {
    /**
     * Selects the favorite red apple card from the given list of submissions.
     *
     * @param redAppleSubmissions the list of submitted red apple cards.
     * @param judge               the judge responsible for selecting the favorite card.
     * @return the card selected as the favorite.
     */
    Card selectFavorite(List<Card> redAppleSubmissions, Judge judge);
}
