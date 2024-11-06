import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create 10 tasks to submit to the executor
        for (int i = 0; i < 20; i++) {
            executor.submit(new Task());
        }

        // Shut down the executor
        executor.shutdown();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        // Print the thread name
        System.out.println("Running in: " + Thread.currentThread().getName());

        // Sleep for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished__ in: " + Thread.currentThread().getName());
    }
}
