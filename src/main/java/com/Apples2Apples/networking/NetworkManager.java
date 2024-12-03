package com.Apples2Apples.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetworkManager {
    private ServerSocket serverSocket;
    private List<Socket> clientSockets = new ArrayList<>();

    public NetworkManager(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public Socket acceptConnection() throws IOException {
        Socket clientSocket = serverSocket.accept();
        clientSockets.add(clientSocket);
        return clientSocket;
    }

    public void closeConnections() throws IOException {
        for (Socket socket : clientSockets) {
            socket.close();
        }
        serverSocket.close();
    }
}