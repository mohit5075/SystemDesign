package EvenOdd;

public class EvenOdd {
    private int counter;
    public EvenOdd(){
        this.counter=0;
    }
    public synchronized void printEven() throws InterruptedException {
        while(counter<=100){
            while (counter % 2 == 1) {
                wait();
            }
            if(counter<=100)
            System.out.println(counter+" printed by "+Thread.currentThread().getName());
            counter++;
            notifyAll();
        }
    }
    public synchronized void printOdd() throws InterruptedException {
        while(counter<=100){
            while (counter % 2 == 0) {
                wait();
            }

            if(counter<=100)
            System.out.println(counter+" printed by "+Thread.currentThread().getName());
            counter++;
            notifyAll();
        }
    }
}
