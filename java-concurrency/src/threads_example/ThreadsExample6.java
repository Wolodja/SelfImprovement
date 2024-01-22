package threads_example;

public class ThreadsExample6 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " finished");
        };

        Thread thread = new Thread(runnable, "The thread");
        thread.start();
    }
}
