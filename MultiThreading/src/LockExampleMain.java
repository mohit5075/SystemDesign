public class LockExampleMain {
    public static void main(String[] args) throws InterruptedException {
        LockExample lockExample = new LockExample();
        Thread thread1 = new Thread(()->{
            lockExample.func1();
        });
        Thread thread2 = new Thread(()->{
            lockExample.func2();
        });
        Thread thread3 = new Thread(()->{
            lockExample.func3();
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
    }
}
