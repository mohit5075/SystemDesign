import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        System.out.println("Starting asynchronous pipeline...");
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "FetchedUser101";
        }).thenApply(username->{
            System.out.println("Transforming name to uppercase...");
            return username.toUpperCase();
        }).thenAccept(upperCasedName->{
            System.out.println("upper case name: "+upperCasedName);
        });

        System.out.println("Pipeline started. Main thread is NOT blocked and can do other work.");
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}
