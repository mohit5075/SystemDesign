import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SharedResource {
    int size;
    private Queue<Integer> buffer ;
    public SharedResource(int size){
        this.size = size;
        buffer = new LinkedList<>();
    }
    public synchronized void produce(int item) throws InterruptedException {
        while(buffer.size() == size){
            System.out.println("Waiting for consumer thread to consume");
            wait();
        }
        buffer.add(item);
        System.out.println("Item added: "+item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while(buffer.isEmpty()){
            System.out.println("Waiting for producer thread to produce");
            wait();
        }
        int item  = buffer.poll();
        System.out.println("removed item: "+item);
        notify();
        return item;
    }
}
