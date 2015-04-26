/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ClientChangeListener;

/**
 * @author nora
 *
 */
public class ClientPanel extends JPanel implements ClientChangeListener {

	private ChatClient client; 
	
	private final JLabel usernameLabel;
	private final JLabel portLabel;
	private final JLabel ipLabel;
	
	private final JTextField usernameField;
	private final JTextField portField;
	private final JTextField ipField;
	private final JTextField messageField;
	
	private final JButton startButton;
	private final JButton sendButton;
	
	private final JPanel startPanel;
	private final JPanel userInfoPanel;
	private final JPanel sendPanel;
	
	/**
	 * Constructor for ClientPanel takes in an instance of the ChatClient
	 * that it will be representing.
	 */
	public ClientPanel(ChatClient chatClient) {
		this.client = chatClient;
		chatClient.addClientChangeListener(this);
		
		usernameLabel = new JLabel("username: ");
		portLabel = new JLabel("port: ");
		ipLabel = new JLabel("server IP: ");
		
		usernameField = new JTextField();
		portField = new JTextField();
		ipField = new JTextField();
		messageField = new JTextField();
		
		startButton = new JButton("Start");
		sendButton = new JButton("Send");
		
		startPanel = createStartPanel();
		userInfoPanel = createUserInfoPanel();
		sendPanel = createSendPanel();
	}
	
	private JPanel createStartPanel() {
		JPanel panel = new JPanel();
		return panel;
	}
	
	private JPanel createUserInfoPanel() {
		JPanel panel = new JPanel();
		return panel;
	}
	
	private JPanel createSendPanel() {
		JPanel panel = new JPanel();
		return panel;
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
