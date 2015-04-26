package edu.cmu.cs.cs214.rec15;

import javax.swing.JFrame;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ChatClientImpl;
import edu.cmu.cs.cs214.rec15.gui.ClientPanel;
import edu.cmu.cs.cs214.rec15.server.ChatServer;
import edu.cmu.cs.cs214.rec15.server.ChatServerImpl;

/**
 * Main class for Recitation 15.
 * 
 * @author tsun
 *
 */
public class Main {
    
    /**
     * Runs the chat master server.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ChatClient client = new ChatClientImpl();
    	JFrame frame = new JFrame("Recitation 15 is Awesome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ClientPanel clientPanel = new ClientPanel(client);
        frame.setContentPane(clientPanel);
        
        // Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
}
