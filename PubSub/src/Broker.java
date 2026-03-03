import java.util.List;
import java.util.Map;

public class Broker {
    Map<String,Topic> topics;
    public void createTopic(String topicName) {
        topics.put(topicName, new Topic());
    }
    public void deleteTopic(String topicName) {
        topics.remove(topicName);
    }
    public void publishMessage(String topicName, Message message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.notifySubscribers(message);
        }
    }
}
