package edu.cmu.cs.cs214.rec15;

import edu.cmu.cs.cs214.rec15.server.ChatServer;
import edu.cmu.cs.cs214.rec15.server.ChatServerImpl;

/**
 * Main class for Recitation 15.
 * 
 * @author tsun
 *
 */
public class Main {
    private static final int DEFAULT_PORT = 15214;
    
    /**
     * Runs the chat master server.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ChatServer server = null;
        if (args.length > 0){
            try {
            server = new ChatServerImpl(Integer.parseInt(args[0]));
            } catch (NumberFormatException e){
                printHelp();
                System.exit(1);
            }
        }else{
            server = new ChatServerImpl(DEFAULT_PORT);
        }
        server.startServer();
    }
    
    private static void printHelp() {
        System.err.println("Usage: ./server [PORT]");
    }
}
