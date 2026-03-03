import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SingleThreadedJobScheduler implements JobScheduler{
    private Map<String,Job> jobMap = new HashMap<>();
    private PriorityQueue<Job> priorityQueue = new PriorityQueue<>((a,b)->{
        if(!a.getScheduleTime().equals(b.getScheduleTime())){
            return Long.compare(a.getScheduleTime(), b.getScheduleTime());
        }else return Integer.compare(b.getPriority(),a.getPriority());
    });
    @Override
    public void schedule(Runnable task, Long scheduleTime, int priority) {
        Job job = new Job(scheduleTime,priority,task);
        jobMap.put(job.getJobId(),job);
        priorityQueue.add(job);
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
        while(!priorityQueue.isEmpty()){
            Job job = priorityQueue.peek();
            if(job.getScheduleTime()>currTime)break;
            priorityQueue.poll();
        }
    }

    public int getSize(){
        return priorityQueue.size();
    }
}
