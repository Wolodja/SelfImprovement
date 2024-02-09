package thread_local;

public class ThreadLocalLazyInitExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        String value = threadLocal.get();
        if (value == null) {
            threadLocal.set("Lazily set value");
            value = threadLocal.get();
        }

        System.out.println(value);
    }
}
