import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private List<Worker> workers;
    private CustomBlockingQueue<Runnable> queue;
    private boolean isShutDown = false;
    public ThreadPool(int poolSize,int queueSize){
        queue = new CustomBlockingQueue<>(queueSize);
        this.workers = new ArrayList<>();
        for(int i=0;i<poolSize;i++){
            Worker worker = new Worker(queue);
            workers.add(worker);
            worker.start();
        }
    }
    public void submit(Runnable task) throws InterruptedException {
        if(isShutDown){
            System.out.println("ThreadPool ShutDown");
            return;
        }
        queue.put(task);
    }
    public void shutDown(){
        this.isShutDown = true;
        for(Worker worker : workers){
            worker.stopWorker();
        }
    }
}
