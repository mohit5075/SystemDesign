package ProducerConsumer;

public class Demo {
    public static void main(String[] args) {
        SharedBuffer<Integer> sharedBuffer = new SharedBuffer<>(5);

        Thread producer = new Thread(()->{
            int start=1;
            while(true){
                try {
                    sharedBuffer.produce(start);
                    start++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(()->{
            while(true){
                try {
                    System.out.println(sharedBuffer.consume());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
