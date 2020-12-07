package Lesson7;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Date sendAt;
    private String author;
    private String message;
    private SerialHandler handler;

    public static Message of(String author, String message) {
        Message m = new Message();
        m.setAuthor(author);
        m.setMessage(message);
        m.setSendAt(new Date());
        return m;
    }

    public Message() {
    }

    public Date getSendAt() {
        return sendAt;
    }

    public void setSendAt(Date sendAt) {
        this.sendAt = sendAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getUserNameOfClient(SerialHandler handler) {
        return handler.getUserName();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return author + ": " + message +
                "\nотправлено: " + sendAt;
    }
}
