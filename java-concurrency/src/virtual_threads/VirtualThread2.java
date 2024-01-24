package virtual_threads;

import java.util.ArrayList;
import java.util.List;

public class VirtualThread2 {

    public static void main(String[] args) {
        List<Thread> vThreads = new ArrayList<>();

        int threadCount = 1_000_000;
        for (int i = 0; i < threadCount; i++) {
            int index = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println("Result[" + index + "]: " + result);
            });
            vThreads.add(vThread);
        }

        for (int i = 0; i < vThreads.size(); i++) {
            try {
                vThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
