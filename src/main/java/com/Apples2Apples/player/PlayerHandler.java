//package com.Apples2Apples.model;
//
//import com.Apples2Apples.Game;
//
//import java.io.*;
//import java.net.*;
//
//public class PlayerHandler implements Runnable {
//    private Player player;
//    private Game game;
//
//    public PlayerHandler(Player player, Game game) {
//        this.player = player;
//        this.game = game;
//    }
//
//    @Override
//    public void run() {
//        try {
//            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(player.getSocket().getInputStream()));
//            DataOutputStream outToClient = new DataOutputStream(player.getSocket().getOutputStream());
//
//            while (true) {
//                // Communication with the client (e.g., receiving player moves)
//                String playerMove = inFromClient.readLine(); // Example of receiving a move
//                if (playerMove != null) {
//                    System.out.println("Received from player " + player.getPlayerID() + ": " + playerMove);
//                }
//                // Handle the player actions here, e.g., sending game state updates, cards, etc.
//            }
//        } catch (IOException e) {
//            System.err.println("Error with player " + player.getPlayerID() + ": " + e.getMessage());
//        }
//    }
//}
