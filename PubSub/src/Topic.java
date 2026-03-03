import java.util.List;

public class Topic {
    List<Subscriber> subscribers;
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
    public void notifySubscribers(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}
