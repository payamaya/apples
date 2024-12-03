//package com.Apples2Apples.player;
//
//import java.net.Socket;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.util.List;
//
//public abstract class AbstractPlayer implements IPlayer {
//    protected int playerID;
//    protected Socket socket;
//    protected BufferedReader reader;
//    protected DataOutputStream writer;
//    protected List<String> hand;
//    protected boolean isJudge;
//
//    // Constructor that accepts values for all fields
//    public AbstractPlayer(int playerID, Socket socket, BufferedReader reader, DataOutputStream writer, List<String> hand) {
//        this.playerID = playerID;
//        this.socket = socket;
//        this.reader = reader;
//        this.writer = writer;
//        this.hand = hand;
//        this.isJudge = false;
//    }
//
//    public int getPlayerID() {
//        return playerID;
//    }
//
//    public List<String> getHand() {
//        return hand;
//    }
//
//    public void setHand(List<String> hand) {
//        this.hand = hand;
//    }
//
//    public boolean isJudge() {
//        return isJudge;
//    }
//
//    public void setJudge(boolean isJudge) {
//        this.isJudge = isJudge;
//    }
//
//    public String playCard(String greenApple){
//        return null;
//    };
//
//    public abstract void replenishRedApples();
//}
