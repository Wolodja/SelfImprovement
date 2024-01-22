package threads_example;

public class ThreadsExample3 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyRunnable running");
                System.out.println("MyRunnable finished");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
