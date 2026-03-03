import java.time.LocalDateTime;

public class FixedWindowCounter {
    private Long startTime;
    private int requestCount;

    public FixedWindowCounter(Long startTime, int requestCount) {
        this.startTime = startTime;
        this.requestCount = requestCount;
    }
    public int getRequestCount(){
        return requestCount;
    }
    public Long getStartTime(){
        return startTime;
    }
    public void reduceCount(){
        requestCount-=1;
    }
}
