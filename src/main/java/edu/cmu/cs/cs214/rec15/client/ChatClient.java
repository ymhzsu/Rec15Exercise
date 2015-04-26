package edu.cmu.cs.cs214.rec15.client;

public interface ChatClient {
    
    public boolean sendMessage(String message);
    
    public void setUsername(String username);
}
