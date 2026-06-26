import lockint.ReadWriteLock;

import java.util.concurrent.locks.Lock;

public class CustomReadWriteLock implements ReadWriteLock {
    private int activeReaders;
    private int activeWriters;
    private int waitingWriters;
    @Override
    public synchronized void lockRead() throws InterruptedException {
        while(activeWriters>0 || waitingWriters>0){
            wait();
        }
        activeReaders++;
    }

    @Override
    public void unLockRead() {
        activeReaders--;
        notifyAll();
    }

    @Override
    public synchronized void lockWrite() throws InterruptedException {
        waitingWriters++;
        while (activeWriters>0 || activeReaders>0){
            wait();
        }
        activeWriters++;
        waitingWriters--;
    }

    @Override
    public void unLockWrite() {
        activeWriters--;
        notifyAll();
    }
}
