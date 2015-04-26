/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import edu.cmu.cs.cs214.rec15.client.ChatClient;

/**
 * @author nora
 *
 */
public class SendMessageListener implements ActionListener {
	
	private JTextField message;
	private ChatClient chatClient;

	/**
	 * 
	 */
	public SendMessageListener(JTextField messageField, ChatClient client) {
		this.message = messageField;
		this.chatClient = client;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// attempt to send message
		if (chatClient.sendMessage(message.getText())){
			System.out.println(message.getText());
			// if the message was sent successfully, clear out the field
			message.setText("");
			message.requestFocus();
		}
		else {
			// TODO : print out some error message saying the message could not be sent.
			
		}

	}

}
