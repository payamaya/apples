package com.Apples2Apples.networking;

public interface INetworkClient {
    void connect();
    void sendMessage(String message);
    String receiveMessage();
    void disconnect();
}
