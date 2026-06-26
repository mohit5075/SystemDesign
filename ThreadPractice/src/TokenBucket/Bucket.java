package TokenBucket;

public class Bucket implements TokenBucket{
    private int capacity;
    private int currentTokens;
    private int refillRate;
    private Long lastRefillTimeStamp;
    public Bucket(int capacity,int refillRate,long lastRefillTimeStamp){
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefillTimeStamp = lastRefillTimeStamp;
        this.currentTokens = capacity;
    }
    @Override
    public synchronized boolean allow() {
        refill();
        if(currentTokens>0){
            System.out.println("Allowing Request");
            currentTokens--;
            return true;
        }
        System.out.println("Not Allowing Request");
        return false;
    }
    private void refill(){
        Long currentTimeStamp = System.currentTimeMillis();
        int tokensToAdd = (int) (((currentTimeStamp-lastRefillTimeStamp)/1000)*refillRate);
        if(tokensToAdd>0){
            currentTokens = Math.min(capacity,currentTokens+tokensToAdd);
            lastRefillTimeStamp = currentTimeStamp;
        }
    }
}
