import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        LinkedMessageQueue messageQueue = new LinkedMessageQueue(5);
        Producer producer = new Producer(messageQueue);
        Consumer consumer = new Consumer(messageQueue);
        Thread producerth = new Thread(producer);
        Thread consumerth = new Thread(consumer);
        producerth.start();
        consumerth.start();
    }
}