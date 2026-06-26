package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer<T>{
    private Queue<T> queue = new LinkedList<>();
    private int capacity;
    public SharedBuffer(int capacity){
        this.capacity = capacity;
    }
    public synchronized T consume() throws InterruptedException {
        while (queue.isEmpty())wait();
        Thread.sleep(200);
        T t = queue.poll();
        notifyAll();
        return t;
    }
    public synchronized void produce(T t) throws InterruptedException {
        while(queue.size()==capacity){
            wait();
        }
        Thread.sleep(200);
        queue.offer(t);
        notifyAll();
    }
}
