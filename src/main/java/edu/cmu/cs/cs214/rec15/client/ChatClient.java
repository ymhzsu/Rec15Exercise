package edu.cmu.cs.cs214.rec15.client;

public interface ChatClient {

    /**
     * Sends the message the server it is connected to
     * 
     * @param message
     *            Message to be sent
     * @return True if the message was successfully sent, false otherwise
     */
    public boolean sendMessage(String message);


    /**
     * Sets the username of the client
     * 
     * @param username
     *            Username of the client
     */
    public void setUsername(String username);
}
