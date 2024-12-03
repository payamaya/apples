package com.Apples2Apples.game;

import com.Apples2Apples.util.LoggerUtil;

public class JudgePhase extends GamePhase {
        private static final LoggerUtil logger = LoggerUtil.getInstance(JudgePhase.class);
    @Override
    public void execute() {
        // Judge chooses a winner based on the green apple
        logger.info("Judge selects the winner.");
    }
}
