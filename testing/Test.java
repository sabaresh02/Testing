package testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {

    // Define a ThreadFactory to set custom names for each thread
    static class NamedThreadFactory implements ThreadFactory {
        private final String baseName;
        private int threadCount = 1;

        public NamedThreadFactory(String baseName) {
            this.baseName = baseName;
        }

        @Override
        public Thread newThread(Runnable r) {
            // Custom name using the base name and thread count
            Thread thread = new Thread(r, baseName + "-Thread-" + threadCount++);
            return thread;
        }
    }

    public static void main(String[] args) {
        // Create an executor service with a custom thread factory
        ExecutorService executor = Executors.newFixedThreadPool(3, new NamedThreadFactory("CustomExecutor"));

        // Submit tasks
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task");
                try {
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shut down the executor
        executor.shutdown();
    }
}
