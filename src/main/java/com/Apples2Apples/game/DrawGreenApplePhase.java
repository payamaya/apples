package com.Apples2Apples.game;

//package com.Apples2Apples.game;
//
//import com.Apples2Apples.util.LoggerUtil;
//
//public class DrawGreenApplePhase extends GamePhase {
//    private static final LoggerUtil logger = LoggerUtil.getInstance(DrawGreenApplePhase.class);
//
//    @Override
//    public void initializePhase() {
//        logger.info("Initializing Draw Green Apple phase.");
//    }
//
//    @Override
//    public void performPhase() {
//        // Logic to draw a green apple card
//        logger.info("Green apple card drawn.");
//    }
//
//    @Override
//    public void completePhase() {
//        logger.info("Completed Draw Green Apple phase.");
//    }
//}
public class DrawGreenApplePhase extends GamePhase {
    @Override
    public void execute() {
        // Logic for drawing a green apple from the deck
        System.out.println("Green apple drawn.");
    }
}