package edu.cmu.cs.cs214.rec15.server;

import java.util.ArrayList;

public interface ChatServer {

    /**
     * Gets the number of clients connected to the server
     * 
     * @return number of clients currently connected to the server
     */
    public int getNumClients();


    /**
     * Gets the message log of the server
     * 
     * @return message log of the server
     */
    public ArrayList<Message> getMessages();


    /**
     * Sets the port of the ChatServer
     * 
     * @param port
     *            Port to listen on
     */
    public void setPort(int port);


    /**
     * Starts the master server
     */
    public void startServer();
    
    /**
     * Stops the server
     */
    public void stopServer();

}
