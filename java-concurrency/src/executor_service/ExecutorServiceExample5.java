package executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        try {
            String result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg){
        return () -> Thread.currentThread().getName() + ": " + msg;

    }

}
