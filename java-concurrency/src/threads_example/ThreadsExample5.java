package threads_example;

public class ThreadsExample5 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running");
        };

        Thread thread = new Thread(runnable, "The thread");
        thread.start();
        Thread thread2 = new Thread(runnable, "The thread 2");
        thread2.start();
    }
}
