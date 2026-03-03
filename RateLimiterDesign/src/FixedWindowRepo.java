import java.util.HashMap;
import java.util.Map;

public class FixedWindowRepo {
    private Map<String,FixedWindowCounter> counterMap = new HashMap<>();
    public void addCounter(String userId, FixedWindowCounter fixedWindowCounter){
        counterMap.put(userId,fixedWindowCounter);
    }
    public FixedWindowCounter getCounter(String userId){
        return counterMap.get(userId);
    }
}
