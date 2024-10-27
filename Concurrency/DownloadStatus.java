package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// import java.util.concurrent.locks.Lock;
// import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone;
    private AtomicInteger totalByte = new AtomicInteger();

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        this.isDone = true;
    }

    public AtomicInteger getTotalByte() {
        return totalByte;
    }

    public void incrementTotalByte() {
        //lock.lock();
        totalByte.incrementAndGet();
        //lock.unlock(); // it is better to wrap it around a try/finally block
    }
}
