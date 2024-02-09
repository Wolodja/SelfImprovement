package thread_local;

public class ThreadLocalInitialValueExample {

    public static void main(String[] args) {
        ThreadLocal<MyObject> threadLocal1 = new ThreadLocal<>() {
            @Override
            protected MyObject initialValue() {
                return new MyObject();
            }
        };

        ThreadLocal<MyObject> threadLocal2 = ThreadLocal.withInitial(() -> new MyObject());

        Thread thread1 = new Thread(() -> {
            System.out.println("threadLocal1: " + threadLocal1.get());
            System.out.println("threadLocal2: " + threadLocal2.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("threadLocal1: " + threadLocal1.get());
            System.out.println("threadLocal2: " + threadLocal2.get());
        });

        thread1.start();
        thread2.start();
    }

}
