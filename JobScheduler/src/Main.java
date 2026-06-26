import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        JobScheduler jobScheduler = new SingleThreadedJobScheduler();
//        jobScheduler.schedule(()-> System.out.println("low priority task"), 1000L,
//                1);
//        jobScheduler.schedule(()-> System.out.println("high priority task"), 2000L,
//                2);
//        long start = 0;
//
//        while (true) {
//            jobScheduler.tick(start);
//            if(jobScheduler.getSize()==0)break;
//            start += 1000;
//            Thread.sleep(1000);
//        }
        JobScheduler scheduler = new MultiThreadedJobScheduler();

        long now = System.currentTimeMillis();

        scheduler.schedule(() -> {
            System.out.println("Low priority task " + Thread.currentThread().getName());
        }, now + 2000, 1);

        scheduler.schedule(() -> {
            System.out.println("High priority task " + Thread.currentThread().getName());
        }, now + 2000, 10);

        scheduler.schedule(() -> {
            System.out.println("Another task " + Thread.currentThread().getName());
        }, now + 1000, 5);

        Thread.sleep(5000);
        ((MultiThreadedJobScheduler) scheduler).shutdown();

        PriorityQueue<Job> jobQueue = new PriorityQueue<>((a,b)->{
            if(a.getScheduleTime()!=b.getScheduleTime())return Long.compare(a.getScheduleTime(), b.getScheduleTime());
            return Integer.compare(b.getPriority(),a.getPriority());
        });
    }
}