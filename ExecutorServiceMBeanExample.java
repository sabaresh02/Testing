import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.*;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ExecutorServiceMBeanExample {
    public static void main(String[] args) throws InterruptedException {

        int newCount = 0;
        int runnableCount = 0;
        int blockedCount = 0;
        int waitingCount = 0;
        int timedWaitingCount = 0;
        int terminatedCount = 0;
        // Create a ThreadPoolExecutor with a fixed thread pool of size 5
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);


        // Submit some tasks to the executor
        for (int i = 0; i < 20; i++) {

            final int taskId = i;
            executor.submit(() -> {
                int count=0;
                try {
                    for(int k= 0;k<1000;k++){
//                        File f = new File("hai");
//                        FileWriter bufferedWriter= new FileWriter(f);
//                        bufferedWriter.append("sdjlskdjlskdjfflskdfjl");
//                        bufferedWriter.write("lskdflskdjf");
//                        bufferedWriter.close();
                        count++;
                    }
                    System.out.println("count ="+ count);
                    sleep(500); // Simulate some work
//                    System.out.println("Task " + taskId + " completed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

// Force shutdown if needed
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long a[] = threadMXBean.getAllThreadIds();
        sleep(1000);
        for(long i :a){

            ThreadInfo info = threadMXBean.getThreadInfo(i);
            Thread.State state = info.getThreadState();
            switch (state) {
                case NEW -> newCount++;
                case RUNNABLE -> runnableCount++;
                case BLOCKED -> blockedCount++;
                case WAITING -> waitingCount++;
                case TIMED_WAITING -> timedWaitingCount++;
                case TERMINATED -> terminatedCount++;
            }

            long cpuTime = threadMXBean.getThreadCpuTime(i);
            long userTime = threadMXBean.getThreadUserTime(i);
            info.getThreadName();
            System.out.println("Thread ID: " + i + " CPU Time: " + cpuTime + " ns User Time: " + userTime + " ns");

            MonitorInfo mingo[] = info.getLockedMonitors();
            LockInfo[] sinfo = info.getLockedSynchronizers();
            long acount = info.getBlockedCount();

            System.out.println("Thread Count: "+ info);
        }
        System.out.println("Thread Count "+threadMXBean.getThreadCount());
        System.out.println("Peak Thread Count "+threadMXBean.getPeakThreadCount());
        System.out.println("Total Started Thread Count "+threadMXBean.getTotalStartedThreadCount() );
        System.out.println("Total Deamon Thread Count " +threadMXBean.getDaemonThreadCount());

        System.out.println("NEW - " + newCount);
        System.out.println("RUNNABLE - " + runnableCount);
        System.out.println("BLOCKED - " + blockedCount);
        System.out.println("WAITING - " + waitingCount);
        System.out.println("TIMED_WAITING - " + timedWaitingCount);
        System.out.println("TERMINATED - " + terminatedCount);


        // Allow some time for tasks to complete
//        Thread.sleep(3000);

//        // Display executor status
//        System.out.println("Active Threads: " + executor.getActiveCount());
//        System.out.println("Completed Tasks: " + executor.getCompletedTaskCount());
//        System.out.println("Total Tasks: " + executor.getTaskCount());
//        System.out.println("Total Queue: " + executor.getQueue().size());
//        BlockingQueue<Runnable> a = executor.getQueue();
        // Shutdown the executor
        executor.shutdown();
        int aa = 0;
        int[] c = {aa};
//        c.length;
    }
}
