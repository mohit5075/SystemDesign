import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManager {
    private ConcurrentHashMap<String,ConcurrentHashMap<String, AtomicInteger>> inventory = new ConcurrentHashMap<>();
    public void addInventory(String productId,String sellerId,int delta){
        ConcurrentHashMap<String,AtomicInteger> sellers = inventory.get(productId);
        sellers.putIfAbsent(sellerId, new AtomicInteger(0));
        AtomicInteger atomicInteger = sellers.get(sellerId);
        atomicInteger.addAndGet(delta);
    }
    public boolean reduceInventory(String productId,String sellerId,int delta){
        ConcurrentHashMap<String,AtomicInteger> sellers = inventory.get(productId);
        if(sellers.isEmpty())return false;
        AtomicInteger atomicInteger = sellers.get(sellerId);
        int currentValue = atomicInteger.get();
        if(currentValue<delta)return false;
        atomicInteger.addAndGet(-1*delta);
        return true;
    }
    public int getInventory(String productId,String sellerId){
        ConcurrentHashMap<String,AtomicInteger> sellers = inventory.get(productId);
        if(sellers.isEmpty())return 0;
        AtomicInteger atomicInteger = sellers.get(sellerId);
        return atomicInteger.get();
    }
}
