//package com.Apples2Apples.judging;
//
//import com.Apples2Apples.card.Card;
//import com.Apples2Apples.player.Player;
//
//import java.util.List;
//import java.util.Random;
//
//public class Judge {
//    private Player judgePlayer;
//
//    public Judge(Player judgePlayer) {
//        this.judgePlayer = judgePlayer;
//    }
//
//    public Player getJudgePlayer() {
//        return judgePlayer;
//    }
//
//    public void setJudgePlayer(Player judgePlayer) {
//        this.judgePlayer = judgePlayer;
//    }
//
//    public Card selectFavorite(List<Card> submissions) {
//        Random random = new Random();
//        return submissions.get(random.nextInt(submissions.size()));
//    }
//}
