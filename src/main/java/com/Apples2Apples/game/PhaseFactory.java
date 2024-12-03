//package com.Apples2Apples.game;
//
//public class PhaseFactory {
//
//    public static GamePhase createPhase(String phaseType) {
//        switch (phaseType) {
//            case "DRAW_GREEN":
//                return new DrawGreenApplePhase();
//            case "SUBMIT_RED":
//                return new SubmitRedApplePhase();
//            case "JUDGE":
//                return new JudgeSelectionPhase();
//            case "REPLENISH":
//                return new ReplenishHandPhase();
//            default:
//                throw new IllegalArgumentException("Invalid phase type: " + phaseType);
//        }
//    }
//}
