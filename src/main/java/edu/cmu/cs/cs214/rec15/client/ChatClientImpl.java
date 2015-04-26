package edu.cmu.cs.cs214.rec15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.cs214.rec15.gui.ClientChangeListener;
import edu.cmu.cs.cs214.rec15.server.Message;
import edu.cmu.cs.cs214.rec15.util.Log;

public class ChatClientImpl extends Thread implements ChatClient {
    private static final String TAG = "CLIENT";
    private Socket socket = null;
    private String username;
    ObjectOutputStream out;
    private List<ClientChangeListener> listeners;

    public ChatClientImpl(String host, int port) {
        connectToServer(host, port);
        listeners = new ArrayList<ClientChangeListener>();
    }

    public void addClientChangeListener(ClientChangeListener listener) {
    	listeners.add(listener);
    }
    
    public void removeClientChangeListener(ClientChangeListener listener) {
    	listeners.remove(listener);
    }

    public void run() {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(
                        socket.getInputStream());
                Message msg = (Message) in.readObject();
                System.out.println(msg);
                System.out.println();
            }
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.toString());
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
            Log.i(TAG, String.format("Connected to server %s:%d.", host, port));
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            Log.e(TAG, String.format("Could not connect to %s:%d",
                    host, port));
        }
    }


    public static void main(String[] args) {
        ChatClientImpl client = new ChatClientImpl("localhost", 15214);
        client.setUsername(args[0]);
        client.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            while (true) {
                msg = br.readLine();
                if (msg.equals("/quit")) {
                    break;
                }
                client.sendMessage(msg);
                System.out.println();
            }
        } catch (IOException ioe) {
            System.out.println("Error reading from system in");
            System.exit(1);
        }
        try {
            br.close();
        } catch (IOException e) {
            // Ignore
        }
        System.exit(1);
    }
}
