public class Worker extends Thread{
    private BlockingQueue queue;
    private volatile boolean isStopped = false;
    public Worker(CustomBlockingQueue blockingQueue){
        this.queue = blockingQueue;
    }
    @Override
    public void run() {
        while(!isStopped){
            try {
                Runnable task = (Runnable) queue.take();
                task.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stopWorker(){
        this.isStopped = true;
    }
}

// Stock : String name, String symbol, int price
// Order: id, userid, ordertype, ordercategory, orderstatus, stock, quantity, amount
// OrderType: buy,sell
// OrderCategory : limit,market
// OrderStatus : pending, completed, cancelled
// Trade : id, buyerId, sellerId, stock, quantity, price
// orderBook : priorityqueue<Order>buy (maxheap),sell (minheap)
// exchange : map<String,orderbook>
// broker :
// wallet : amount
// portfolio : Map<String,quantity> stocks
// user : id,name,email,wallet,portfolio
