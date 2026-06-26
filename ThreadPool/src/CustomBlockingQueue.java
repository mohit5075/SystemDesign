import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<T> implements BlockingQueue<T>{
    private Queue<T> queue;
    private int capacity;
    public CustomBlockingQueue(int capacity){
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }
    @Override
    public synchronized void put(T t) throws InterruptedException {
        while(queue.size() == capacity){
            wait();
        }
        queue.add(t);
        notifyAll();
    }

    @Override
    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }
        T ouput = queue.poll();
        notifyAll();
        return ouput;
    }
}
