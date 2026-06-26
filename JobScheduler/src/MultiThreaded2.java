import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThreaded2 implements JobScheduler{
    private Map<String,Job> jobMap = new HashMap<>();
    private PriorityQueue<Job> jobQueue = new PriorityQueue<>((a,b)->{
        if(!a.getScheduleTime().equals(b.getScheduleTime()))return Long.compare(a.getScheduleTime(),b.getScheduleTime());
        return Integer.compare(b.getPriority(),a.getPriority());
    });
    private boolean isRunning=true;
    private ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public MultiThreaded2(){
        Thread thread = new Thread(this::runScheduler);
        thread.start();
    }
    private void runScheduler(){
        while (isRunning){
            try {
                Job job = jobQueue.peek();
                if(job==null){
                    Thread.sleep(50);continue;
                }
                Long rem = job.getScheduleTime() - System.currentTimeMillis();
                if (rem > 0) {
                    Thread.sleep(rem);continue;
                }
                if(!job.isCancelled()){
                    executors.submit(job.getTask());
                }
                jobQueue.poll();
            }catch (InterruptedException e){

            }
        }
    }

    @Override
    public void schedule(Runnable task, Long scheduleTime, int priority) {
        Job job = new Job(scheduleTime,priority,task);
        jobMap.putIfAbsent(job.getJobId(),job);
    }

    @Override
    public void cancel(String jobId) {
        Job job  = jobMap.get(jobId);
        if(job!=null)job.setCancelled(true);
    }

    @Override
    public void tick(Long currTime) {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
