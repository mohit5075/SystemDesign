public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(10,10);
        for(int i=0;i<10;i++){
            int taskId = i;
            threadPool.submit(()->{
                System.out.println("Thread: "+Thread.currentThread().getName()+" executing "+taskId);
            });
        }
        Thread.sleep(5000);
        threadPool.shutDown();
    }
}