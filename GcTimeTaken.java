import java.lang.management.ManagementFactory;
import java.lang.management.GarbageCollectorMXBean;

public class GcTimeTaken {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Trigger garbage collection to get accurate memory readings
//        runtime.gc();
        for (int i =0 ;i <100;i++){
            cal();
        }
        runtime.gc();
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            long count = gc.getCollectionCount();
            long time = gc.getCollectionTime();
            System.out.println(gc.getName() + ": Count = " + count + ", Time = " + time + " ms");
        }
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Total Memory: %.2f MB%n", totalMemory / (1024.0 * 1024.0));
        System.out.printf("Free Memory: %.2f MB%n", freeMemory / (1024.0 * 1024.0));
        System.out.printf("Used Memory: %.2f MB%n", usedMemory / (1024.0 * 1024.0));


    }
    public static class A {
        int a;
        int[] ab=new int[10000000];
    }
    public static void cal(){

        A ob1 = new A();
    }
}
