package synchronized_example;

public class MultipleMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    public int getCounter1() {
        synchronized (this.monitor1) {
            return counter1;
        }
    }
    public int getCounter2() {
        synchronized (this.monitor2) {
            return counter1;
        }
    }
}
