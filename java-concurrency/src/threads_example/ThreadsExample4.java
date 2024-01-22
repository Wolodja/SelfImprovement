package threads_example;

public class ThreadsExample4 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("MyRunnable running");
            System.out.println("MyRunnable finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
