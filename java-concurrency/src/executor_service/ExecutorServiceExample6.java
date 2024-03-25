package executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample6 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            for(Future future: futures){
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg){
        return () -> Thread.currentThread().getName() + ": " + msg;

    }
}
