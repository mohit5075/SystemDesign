public class TokenBucket {
    private int capacity;
    private int tokens;
    private long refillRateInSeconds;
    private long lastRefillTimestamp;
    public TokenBucket(int capacity, long refillRateInSeconds) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillRateInSeconds = refillRateInSeconds;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }
    public synchronized boolean tryConsume() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }
    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = (now - lastRefillTimestamp) / 1000;
        long tokensToAdd = elapsed * (refillRateInSeconds);
        tokens = Math.min(capacity, tokens + (int) tokensToAdd);
        if(tokens>0)lastRefillTimestamp = now;
    }
}
