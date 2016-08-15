package net.ru.sbt.message;


public class Message {

    private String idFrom;

    private String idDest;

    private String message;

    public Message(String idFrom, String idDest, String message) {
        this.idFrom = idFrom;
        this.idDest = idDest;
        this.message = message;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public String getIdDest() {
        return idDest;
    }

    public String getMessage() {
        return message;
    }
}
