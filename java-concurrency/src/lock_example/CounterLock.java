package lock_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private long count = 0;

    private Lock lock = new ReentrantLock();

    private void inc() {
        try {
            lock.lock();
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    private long getCount() {
        try {
            lock.lock();
            return this.count;
        } finally {
            lock.unlock();
        }
    }
}
