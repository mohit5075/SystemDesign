import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
//        Supplier<Integer> supplier = ()->{
//            return 1;
//        };
//        Consumer<String> consumer = (String temp)->{
//            System.out.println("Consumed : "+temp);
//        };
//        Function<Integer,String> function = (Integer temp)->{
//            if(temp%2==1)return "odd";
//            return "even";
//        };
//        consumer.accept("hvhv");
//        System.out.println(function.apply(5));
//        System.out.println(supplier.get());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            int taskId = i;
            executorService.submit(()->{
                System.out.println("Task no: "+taskId+" by "+Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}