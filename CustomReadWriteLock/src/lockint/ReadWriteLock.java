package lockint;

public interface ReadWriteLock {
    void lockRead() throws InterruptedException;
    void unLockRead();
    void lockWrite() throws InterruptedException;
    void unLockWrite();
}
