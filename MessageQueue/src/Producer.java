import java.util.Queue;

public class Producer implements Runnable{
    private LinkedMessageQueue queue;

    public Producer(LinkedMessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count=1;
        while (true){
            Message message = new Message("message with id: "+count++);
            try {
                System.out.println("Produced message: "+message.toString());
                queue.produce(message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
