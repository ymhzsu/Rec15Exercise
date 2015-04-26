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
	 * 
	 */
	public StartChatListener(JTextField nameField, JTextField portField, JTextField IPField, ChatClient client) {
		mName = nameField;
		mClient = client;
		mIP = IPField;
		mPort = portField;
		
		// TODO: add validation...
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mClient.setUsername(mName.getText());
		mClient.connectToServer(mIP.getText(), Integer.parseInt(mPort.getText()));
	}

}
