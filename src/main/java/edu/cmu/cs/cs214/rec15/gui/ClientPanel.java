/**
 * 
 */
package edu.cmu.cs.cs214.rec15.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.cmu.cs.cs214.rec15.client.ChatClient;
import edu.cmu.cs.cs214.rec15.client.ClientChangeListener;

/**
 * @author nora
 *
 */
public class ClientPanel extends JPanel implements ClientChangeListener {
	private static final int FIELD_WIDTH = 60;
	private static final int INFO_WIDTH = 20;
	private static final int AREA_WIDTH = FIELD_WIDTH + 10;
	private static final int AREA_HEIGHT = 20;
	
	private ChatClient client; 
	
	private final JLabel usernameLabel;
	private final JLabel portLabel;
	private final JLabel ipLabel;
	
	private final JTextField usernameField;
	private final JTextField portField;
	private final JTextField ipField;
	private final JTextField messageField;
	
	private final JScrollPane scrollPane;
	private final JTextArea chatArea;
	
	private final JButton startButton;
	private final JButton sendButton;
	
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
		
		usernameField = new JTextField(FIELD_WIDTH);
		portField = new JTextField(FIELD_WIDTH);
		ipField = new JTextField(FIELD_WIDTH);
		messageField = new JTextField(FIELD_WIDTH);
		
		chatArea = new JTextArea(AREA_HEIGHT, AREA_WIDTH);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		scrollPane = new JScrollPane(chatArea);
		
		startButton = new JButton("Start");
		
		sendButton = new JButton("Send");
	
		this.add(createStartPanel(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(createSendPanel(), BorderLayout.SOUTH);
		
		//this.messageField.setEnabled(false);
		//scrollPane.setEnabled(false);
		//this.sendButton.setEnabled(false);
		sendButton.addActionListener(new SendMessageListener(messageField, client));
		startButton.addActionListener(new StartChatListener(usernameField, portField, ipField, client));
	}
	
	private JPanel createStartPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(createUserInfoPanel());
		panel.add(startButton);
		return panel;
	}
	
	private JPanel createUserInfoPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		namePanel.add(this.usernameLabel);
		namePanel.add(this.usernameField);
		panel.add(namePanel);
		JPanel portPanel = new JPanel();
		portPanel.setLayout(new FlowLayout());
		portPanel.add(this.portLabel);
		portPanel.add(this.portField);
		panel.add(portPanel);
		JPanel ipPanel = new JPanel();		
		ipPanel.setLayout(new FlowLayout());
		ipPanel.add(this.ipLabel);
		ipPanel.add(this.ipField);
		panel.add(ipPanel);
		return panel;
	}
	
	private JPanel createSendPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(this.messageField, BorderLayout.WEST);
		panel.add(this.sendButton, BorderLayout.EAST);
		return panel;
	}

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.rec15.gui.ClientChangeListener#startChat(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void startChat(String username, String port, String IP) {
		this.messageField.setEnabled(true);
		this.scrollPane.setEnabled(true);
		this.sendButton.setEnabled(true);
		this.messageField.requestFocus();
	}

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.rec15.gui.ClientChangeListener#messageReceived(java.lang.String)
	 */
	@Override
	public void messageReceived(String username, String message) {
		String newText = String.format(" %s: %s\n", username, message);
		this.chatArea.append(newText);
	}

}
