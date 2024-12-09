//package com.Apples2Apples.networking;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NetworkManager {
//    private INetworkServer server;
//    private INetworkClient client;
//    private IServerFactory serverFactory;
//
//    public NetworkManager(IServerFactory serverFactory) {
//        this.serverFactory = serverFactory;
//        this.server = serverFactory.createServer();
//        this.client = serverFactory.createClient();
//    }
//
//    public void startServer() throws IOException {
//        server.startServer();
//    }
//
//    public void broadcastMessage(String message) {
//        server.sendMessage(message);  // Delegates to the server to send messages
//    }
//
//    public void stopServer() {
//        server.stopServer();
//    }
//
//    public String getServerType() {
//        return server.getClass().getSimpleName();
//    }
//}