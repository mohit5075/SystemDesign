import java.util.concurrent.*;

public class FutureCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = ()->{
            System.out.println(Thread.currentThread().getName());
            int ans=0;
            for(int i=0;i<=5;i++)ans+=i;
            return ans;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
