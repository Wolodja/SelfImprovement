package race_conditions;

public class RaceConditionsExample2 {

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread thread1 = new Thread(getRunnable(counter1, counter2, "Thread1"));
        Thread thread2 = new Thread(getRunnable(counter2, counter1, "Thread2"));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Counter counterA, Counter counterB, String name){
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counterA.incAndGet();
            }
            System.out.println(name + " final count - counterA:  " + counterA.get());
            System.out.println(name + " final count - counterB:  " + counterB.get());
        };
    }
}
