package com.Apples2Apples.game;

//package com.Apples2Apples.game;
//
//import com.Apples2Apples.util.LoggerUtil;
//
//public class SubmitRedApplePhase extends GamePhase {
//    private static final LoggerUtil logger = LoggerUtil.getInstance(SubmitRedApplePhase.class);
//
//    @Override
//    public void initializePhase() {
//        logger.info("Initializing Submit Red Apple Phase.");
//    }
//
//    @Override
//    public void performPhase() {
//        logger.info("Players are submitting red apple cards.");
//        // Logic for players submitting cards
//    }
//
//    @Override
//    public void completePhase() {
//        logger.info("Completed Submit Red Apple Phase.");
//    }
//}

public class SubmitRedApplePhase extends GamePhase {
    @Override
    public void execute() {
        // Logic for submitting red apples
        System.out.println("Players submit red apples.");
    }
}