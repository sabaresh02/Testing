public class MemoryUsage {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Trigger garbage collection to get accurate memory readings
        runtime.gc();


        class A {
            int a;
            int[] ab=new int[10000000];
        }

        A ob1 = new A();
        A ob2 = new A();
        ob1 = ob2;
        runtime.gc();

        // Get memory details
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;




        System.out.printf("Total Memory: %.2f MB%n", totalMemory / (1024.0 * 1024.0));
        System.out.printf("Free Memory: %.2f MB%n", freeMemory / (1024.0 * 1024.0));
        System.out.printf("Used Memory: %.2f MB%n", usedMemory / (1024.0 * 1024.0));
    }
}
