package edu.cmu.cs.cs214.rec15.server;

import java.util.ArrayList;

public interface ChatServer {
        
    public int getNumClients();
    
    public ArrayList<Message> getMessages();

}
