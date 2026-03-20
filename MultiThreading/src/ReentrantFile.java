import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantFile {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        readLock.lock();
        try {
            System.out.println("read lock");
        }finally {
            readLock.unlock();
        }
    }
}
