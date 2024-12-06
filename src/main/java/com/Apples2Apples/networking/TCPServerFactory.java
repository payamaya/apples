package com.Apples2Apples.networking;

public class TCPServerFactory implements IServerFactory {

    @Override
    public INetworkServer createServer() {
        return new TCPServer(); // TCP-specific implementation of the server
    }

    @Override
    public INetworkClient createClient() {
        return new TCPClient(); // TCP-specific implementation of the client
    }
}
