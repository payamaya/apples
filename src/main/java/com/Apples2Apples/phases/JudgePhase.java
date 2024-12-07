package com.Apples2Apples.phases;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;

import java.util.List;
/**
 * Handles the judging phase of the game.
 * During this phase, the judge evaluates submitted red apple cards and selects a winner.
 */
public class JudgePhase implements GamePhase {
    /**
     * Executes the judging logic where the judge selects the winning red apple card.
     *
     * @param game the current game instance on which the phase operates.
     */
    @Override
    public void execute(Game game) {
        List<Card> submissions = game.getRedAppleSubmissions();
        game.selectWinner(submissions);
    }
}