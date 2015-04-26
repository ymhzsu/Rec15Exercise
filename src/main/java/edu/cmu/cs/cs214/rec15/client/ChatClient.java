package edu.cmu.cs.cs214.rec15.client;

import edu.cmu.cs.cs214.rec15.gui.ClientChangeListener;

public interface ChatClient {
    
    public boolean sendMessage(String message);
    
    public void setUsername(String username);
    
    public void addClientChangeListener(ClientChangeListener listener);
    
    public void removeClientChangeListener(ClientChangeListener listener);
}
