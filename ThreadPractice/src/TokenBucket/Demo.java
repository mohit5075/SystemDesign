package TokenBucket;

public class Demo {
    public static void main(String[] args) {
        Bucket bucket = new Bucket(10,5,System.currentTimeMillis());
        Thread thread = new Thread(()->{
            while(true){
                bucket.allow();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
