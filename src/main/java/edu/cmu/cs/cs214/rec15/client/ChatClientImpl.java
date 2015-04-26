package edu.cmu.cs.cs214.rec15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import edu.cmu.cs.cs214.rec15.server.Message;

public class ChatClientImpl extends Thread implements ChatClient {
    private Socket socket = null;
    private String username;
    ObjectOutputStream out;


    public ChatClientImpl(String host, int port) {
        connectToServer(host, port);
    }


    public void run() {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(
                        socket.getInputStream());
                Message msg = (Message) in.readObject();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean sendMessage(String message) {
        try {
            Message msg = new Message(message, username);
            out.writeObject(msg);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void setUsername(String username) {
        this.username = username;
    }


    private void connectToServer(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println(String.format("Could not connect to %s:%d",
                    host, port));
        }
    }


    public static void main(String[] args) {
        ChatClientImpl client = new ChatClientImpl("localhost", 15214);
        client.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            while (true) {
                System.out.print("> ");
                msg = br.readLine();
                if (msg.equals("/quit")) {
                    br.close();
                }
                client.sendMessage(msg);
                System.out.println();
            }
        } catch (IOException ioe) {
            System.out.println("Error reading from system in");
            System.exit(1);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.exit(1);
    }
}
