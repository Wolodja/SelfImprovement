package memory;

public class MyRunnable implements Runnable {

    int count;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                this.count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
}
