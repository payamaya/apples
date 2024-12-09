//package com.Apples2Apples.networking;
//
//import com.Apples2Apples.common.Constants;
//
//import java.io.*;
//import java.net.*;
//
//public class TCPClient implements INetworkClient {
//    private Socket socket;
//    private PrintWriter out;
//    private BufferedReader in;
//
//    @Override
//    public void connect() {
//        try {
//            socket = new Socket("localhost", Constants.SERVER_PORT.getValue()); // Example server address
//            out = new PrintWriter(socket.getOutputStream(), true);
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
//
//    @Override
//    public void disconnect() {
//        try {
//            out.close();
//            in.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
