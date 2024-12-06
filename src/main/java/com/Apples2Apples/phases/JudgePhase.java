package com.Apples2Apples.phases;

import com.Apples2Apples.card.Card;
import com.Apples2Apples.game.Game;

import java.util.List;

public class JudgePhase implements GamePhase {
    @Override
    public void execute(Game game) {
        List<Card> submissions = game.getRedAppleSubmissions();
        game.selectWinner(submissions);
    }
}