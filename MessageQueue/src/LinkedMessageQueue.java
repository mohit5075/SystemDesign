import java.util.LinkedList;
import java.util.Queue;

public class LinkedMessageQueue {
    private Queue<Message> mq = new LinkedList<>();
    private int capacity;

    public LinkedMessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(Message message) throws InterruptedException {
        while(mq.size()==capacity){
            wait();
        }
        mq.add(message);
        notifyAll();
    }

    public synchronized Message consume() throws InterruptedException {
        while(mq.isEmpty()){
            wait();
        }
        Message message = mq.poll();
        notifyAll();
        return message;
    }
}
