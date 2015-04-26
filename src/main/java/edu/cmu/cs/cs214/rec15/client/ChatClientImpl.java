package edu.cmu.cs.cs214.rec15.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientImpl implements ChatClient {
    private Socket socket = null;
    
    public ChatClientImpl(String host, int port){
        connectToServer(host, port);
    }

    @Override
    public boolean sendMessage(String message) {
        
        return true;
    }


    @Override
    public void setUsername(String username) {
        // TODO Auto-generated method stub

    }
    
    private void connectToServer(String host, int port){
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.err.println(String.format("Could not connect to %s:%d", host, port));
        }
    }

    public static void main(String[] args) {
        new ChatClientImpl("localhost", 15214);
    }
}
