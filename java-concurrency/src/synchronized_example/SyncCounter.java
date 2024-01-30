package synchronized_example;

public class SyncCounter {

    private long counter = 0;

    public synchronized void incCount() {
        this.counter++;
    }

    public synchronized long getCount() {
        return counter;
    }
}
