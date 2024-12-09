//package com.Apples2Apples.networking;
//
//import com.Apples2Apples.common.Constants;
//
//import java.io.*;
//import java.net.*;
//
//public class TCPServer implements INetworkServer {
//    private ServerSocket serverSocket;
//    private Socket clientSocket;
//    private PrintWriter out;
//    private BufferedReader in;
//
//    @Override
//    public void startServer() {
//        try {
//            serverSocket = new ServerSocket(Constants.SERVER_PORT.getValue()); // Example port
//            System.out.println("Server started, waiting for clients...");
//            clientSocket = serverSocket.accept();
//            out = new PrintWriter(clientSocket.getOutputStream(), true);
//            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void acceptClient() {
//        // Implementation to accept clients
//    }
//
//    @Override
//    public void stopServer() {
//        try {
//            out.close();
//            in.close();
//            clientSocket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void sendMessage(String message) {
//        out.println(message);
//    }
//
//    @Override
//    public String receiveMessage() {
//        try {
//            return in.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
