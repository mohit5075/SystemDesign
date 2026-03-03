public class Message {
    private String payload;
    private long timeStamp;

    public Message(String payload) {
        this.payload = payload;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "payload='" + payload + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
