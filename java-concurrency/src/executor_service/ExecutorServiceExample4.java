package executor_service;

import java.util.concurrent.*;

public class ExecutorServiceExample4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());

        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }

        System.out.println(future.isDone());

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg){
        return () -> Thread.currentThread().getName() + ": " + msg;

    }
}
