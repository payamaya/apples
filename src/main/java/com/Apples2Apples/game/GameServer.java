package com.Apples2Apples.game;

import com.Apples2Apples.common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();

    // Constructor with port number (2048)
    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(Constants.SERVER_PORT.getValue());
    }

    // Start the server to accept client connections
    public void start() {
        System.out.println("Server started. Waiting for clients...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
                System.out.println("Client connected.");
            } catch (IOException e) {
                System.out.println("Error accepting client: " + e.getMessage());
            }
        }
    }

    // Broadcast a message to all connected clients
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Handler Error: " + e.getMessage());
            }
        }

        // Send a message to the client
        public void sendMessage(String message) {
            out.println(message);
        }

        // Handle communication with the client
        @Override
        public void run() {
            try {
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    broadcastMessage(input);
                }
            } catch (IOException e) {
                System.out.println("Connection Error: " + e.getMessage());
            }
        }
    }

//    // Main method to start the server
//    public static void main(String[] args) {
//        try {
//            // Create the GameServer instance with port 2048
//            GameServer server = new GameServer(2048);
//            server.start();  // Start the server
//        } catch (IOException e) {
//            System.out.println("Error starting server: " + e.getMessage());
//        }
//    }
}
