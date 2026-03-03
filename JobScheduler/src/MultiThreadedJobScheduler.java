import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedJobScheduler implements JobScheduler{
    private Map<String,Job> jobMap = new ConcurrentHashMap<>();
    private PriorityQueue<Job> priorityQueue = new PriorityQueue<>((a, b)->{
        if(!a.getScheduleTime().equals(b.getScheduleTime())){
            return Long.compare(a.getScheduleTime(), b.getScheduleTime());
        }else return Integer.compare(b.getPriority(),a.getPriority());
    });
    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private boolean running = true;
    private Thread schedulerThread;
    public MultiThreadedJobScheduler(){
        schedulerThread = new Thread(this::schedulerLoop);
        schedulerThread.start();
    }
    @Override
    public void schedule(Runnable task, Long scheduleTime, int priority) {
        Job job = new Job(scheduleTime,priority,task);
        priorityQueue.add(job);
        jobMap.put(job.getJobId(), job);
    }

    @Override
    public void cancel(String jobId) {
        Job job = jobMap.get(jobId);
        if(job!=null){
            job.setCancelled(true);
        }
    }

    @Override
    public void tick(Long currTime) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    private void schedulerLoop(){
        while(running){
            try {
                Job job = priorityQueue.peek();
                if(job==null){
                    Thread.sleep(50);
                    continue;
                }
                Long delay = job.getScheduleTime()-System.currentTimeMillis();
                if(delay>0){
                    Thread.sleep(delay);
                    continue;
                }
                priorityQueue.poll();
                jobMap.remove(job.getJobId());
                if(!job.isCancelled()) {
                    executor.submit(job.getTask());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown(){
        running=false;
        executor.shutdown();
        schedulerThread.interrupt();
    }
}
