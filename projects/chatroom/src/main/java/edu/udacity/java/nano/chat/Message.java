package edu.udacity.java.nano.chat;

/**
 * WebSocket message model
 */
public class Message {

    private String name;

    //message status
    public enum Type{
        ENTER, SPEAK, LEAVE
    }
    public Message(){}
    public Message(String text){
        this.name = text;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
