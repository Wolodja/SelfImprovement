package volatile_example;

public class Counter {

    private volatile int count = 0;

    public boolean inc() {
        if (this.count == 10) {
            return false;
        }
        this.count++;
        return true;
    }
}
