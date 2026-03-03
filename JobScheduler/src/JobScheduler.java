public interface JobScheduler {
    void schedule(Runnable task, Long scheduleTime, int priority);
    void cancel(String jobId);
    void tick(Long currTime);
    int getSize();
}
