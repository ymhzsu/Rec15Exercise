/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ClientChangeListener;

/**
 * @author nora
 *
 */
public class ClientPanel implements ClientChangeListener {

	private ChatClient client; 
	
	/**
	 * Constructor for ClientPanel takes in an instance of the ChatClient
	 * that it will be representing.
	 */
	public ClientPanel(ChatClient chatClient) {
		this.client = chatClient;
		chatClient.addClientChangeListener(this);
	}

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.rec15.gui.ClientChangeListener#startChat(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void startChat(String username, String port, String IP) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.rec15.gui.ClientChangeListener#messageReceived(java.lang.String)
	 */
	@Override
	public void messageReceived(String message) {
		// TODO Auto-generated method stub

	}

}
