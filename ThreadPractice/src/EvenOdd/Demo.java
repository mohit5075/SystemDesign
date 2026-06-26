package EvenOdd;

public class Demo {
    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        Thread thread1 = new Thread(()->{
            try {
                evenOdd.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Even Thread");
        Thread thread2 = new Thread(()->{
            try {
                evenOdd.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Odd Thread");
        thread1.start();
        thread2.start();
    }
}
