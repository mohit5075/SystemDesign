public class PubSubService {
    private Broker broker;
    public PubSubService(Broker broker) {
        this.broker = broker;
    }
    public void publish(String topic, Message message) {
        broker.publishMessage(topic, message);
    }
}
