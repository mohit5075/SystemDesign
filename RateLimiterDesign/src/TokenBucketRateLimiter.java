import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter{
    Map<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();
    @Override
    public boolean allowRequest(String userId) {
       TokenBucket bucket= userBuckets.computeIfAbsent(userId, k -> new TokenBucket(5, 1));
       return bucket.tryConsume();
    }
}
