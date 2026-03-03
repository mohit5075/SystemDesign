public class Consumer implements Runnable{
    private LinkedMessageQueue queue;

    public Consumer(LinkedMessageQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            Message message = null;
            try {
                message = queue.consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumed message:"+message.toString());
        }
    }
}
