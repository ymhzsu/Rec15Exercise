package edu.cmu.cs.cs214.rec15.server;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
    private static final long serialVersionUID = 6342932337190682969L;
    private String content;
    private Date timestamp;
    private String sender;
    
    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = new Date();
    }
    
    public Message(String content, String sender, Date timestamp) {
        this.content = content;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }
    
    

}
