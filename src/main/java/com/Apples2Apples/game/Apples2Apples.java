package com.Apples2Apples.game;

import com.Apples2Apples.common.Constants;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Apples2Apples {
    public Apples2Apples(String serverAddress) throws Exception {
        Socket aSocket = new Socket(serverAddress, Constants.SERVER_PORT.getValue());  // Connect to server

        DataOutputStream outToServer = new DataOutputStream(aSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

        // Get the hand of apples from the server
        String[] applesString = inFromServer.readLine().split(";");
        ArrayList<String> hand = new ArrayList<>(Arrays.asList(applesString));

        while (true) {
            // Receive info about the round (judge or not)
            String judgeString = inFromServer.readLine();
            boolean isJudge = judgeString.equals("JUDGE");

            if (judgeString.startsWith("FINISHED")) {
                System.out.println("\n" + judgeString);
                break;
            }

            // Play a red apple
            if (!isJudge) {
                System.out.println("Choose a red apple to play");
                for (int i = 0; i < hand.size(); i++) {
                    System.out.println("[" + i + "] " + hand.get(i));
                }
                int choice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                outToServer.writeBytes(hand.get(choice) + "\n");
                hand.remove(choice);
                System.out.println("Waiting for other players...");
            }

            // Receive the played apples and judge
            String playedApples = inFromServer.readLine();
            System.out.println("Played Apples:\n" + playedApples);

            if (isJudge) {
                System.out.println("Choose which red apple wins");
                int choice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                outToServer.writeBytes(choice + "\n");
            }

            // Receive the winner's red apple
            String winningRedApple = inFromServer.readLine();
            System.out.println("Winning Red Apple: " + winningRedApple);
        }
    }
}
