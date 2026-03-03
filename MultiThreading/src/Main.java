public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        Thread producer = new Thread(()->{
            System.out.println("producer thread started");
            for(int i=1;i<=6;i++) {
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            System.out.println("consumer thread started");
            for(int i=1;i<=6;i++) {
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}