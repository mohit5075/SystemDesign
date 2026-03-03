public class Publisher {
    private PubSubService pubSubService;

    public Publisher(PubSubService pubSubService) {
        this.pubSubService = pubSubService;
    }

    public void publish(String topic, String payload) {
        Message message = new Message();
        message.payload = payload;
        pubSubService.publish(topic, message);
    }
}
