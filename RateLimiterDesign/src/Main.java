public class Main {
    public static void main(String[] args) {
        FixedWindowRepo fixedWindowRepo = new FixedWindowRepo();
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(fixedWindowRepo,5L);
        Thread thread = new Thread(()->{
            while(true) {
                fixedWindowRateLimiter.allowRequest("user1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}