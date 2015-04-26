/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ClientChangeListener;

/**
 * @author nora
 *
 */
public class StartChatListener implements ActionListener {
	
	private ChatClient mClient;
	private String mName;
	private String mIP;
	private String mPort;

	/**
	 * 
	 */
	public StartChatListener(String name, String port, String ip, ChatClient client) {
		mName = name;
		mClient = client;
		mIP = ip;
		mPort = port;
		
		// TODO: add validation...
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mClient.setUsername(mName);
		mClient.connectToServer(mIP, Integer.parseInt(mPort));
	}

}
