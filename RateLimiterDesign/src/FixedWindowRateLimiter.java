import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FixedWindowRateLimiter implements RateLimiter{
    private final FixedWindowRepo fixedWindowRepo;
    private Long windowLength;

    public FixedWindowRateLimiter(FixedWindowRepo fixedWindowRepo,Long windowLength) {
        this.fixedWindowRepo = fixedWindowRepo;
        this.windowLength=windowLength;
    }

    @Override
    public boolean allowRequest(String userId) {
        Map treeMap = new HashMap<>();
        FixedWindowCounter fixedWindowCounter = fixedWindowRepo.getCounter(userId);
        if(fixedWindowCounter==null){
            fixedWindowRepo.addCounter(userId,new FixedWindowCounter(System.currentTimeMillis(),9));
            System.out.println("User with id: "+userId+" does not exist. Creating new counter and allowing request.");
            return true;
        }
        Long t = (System.currentTimeMillis()-fixedWindowCounter.getStartTime())/1000;
        if(t>windowLength){
            System.out.println("Window of User with id: "+userId+" expired. Creating new counter and allowing request.");
            fixedWindowRepo.addCounter(userId,new FixedWindowCounter(System.currentTimeMillis(),9));
            return true;
        }
        if(fixedWindowCounter.getRequestCount()==0) {
            System.out.println("User with id: "+userId+" Rate Limit exceeded.");
            return false;
        }
        System.out.println("User with id: "+userId+" Allowed.");
        fixedWindowCounter.reduceCount();
        return true;
    }
}
