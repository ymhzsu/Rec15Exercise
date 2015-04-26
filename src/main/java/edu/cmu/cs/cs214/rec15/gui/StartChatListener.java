/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ClientChangeListener;

/**
 * @author nora
 *
 */
public class StartChatListener implements ActionListener {
	
	private ChatClient mClient;
	private JTextField mName;
	private JTextField mIP;
	private JTextField mPort;

	/**
	 * Listener for the start button that takes username, ChatServer port, and ChatServer ip information 
	 * and connects the current ChatClient to a ChatServer
	 */
	public StartChatListener(JTextField nameField, JTextField portField, JTextField IPField, ChatClient client) {
		mName = nameField;
		mClient = client;
		mIP = IPField;
		mPort = portField;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mClient.setUsername(mName.getText());
		
		// TODO: add validation...
		
		mClient.connectToServer(mIP.getText(), Integer.parseInt(mPort.getText()));
	}

}
