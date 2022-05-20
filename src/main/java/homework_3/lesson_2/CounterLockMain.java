package homework_3.lesson_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterLockMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(CounterSafe::increment);
        executor.submit(CounterSafe::increment);
        executor.submit(CounterSafe::increment);
        executor.submit(CounterSafe::getCount);
        executor.submit(CounterSafe::increment);
        executor.submit(CounterSafe::increment);
        executor.submit(CounterSafe::decrement);
        executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            CounterSafe.getCount();
        });
        executor.shutdown();
    }
}
