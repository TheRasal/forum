package classes;

public class Messages {
    private String time;
    private String nick;
    private String message;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Messages(String time, String nick, String message) {

        this.nick = nick;
        this.time = time;
        this.message = message;
    }
}
