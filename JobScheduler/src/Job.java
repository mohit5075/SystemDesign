import java.util.UUID;

public class Job {
    private String jobId;
    private Long scheduleTime;
    private int priority;
    private Runnable task;
    private boolean isCancelled;

    public Job(Long scheduleTime, int priority, Runnable task) {
        this.jobId = UUID.randomUUID().toString();
        this.scheduleTime = scheduleTime;
        this.priority = priority;
        this.task = task;
        this.isCancelled = false;
    }

    public Long getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Long scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getJobId() {
        return jobId;
    }
}
