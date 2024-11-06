import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws Exception {
//        // Create a HashMap to store method references
//        HashMap<String, Method> functionMap = new HashMap<>();
//        FunctionMap fm = new FunctionMap();
//
//        // Add methods to the map using Method objects
//        functionMap.put("Hello", FunctionMap.class.getMethod("sayHello"));
//        functionMap.put("bye", FunctionMap.class.getMethod("sayGoodbye"));
//        functionMap.put("greprson", FunctionMap.class.getMethod("greetPerson", String.class));

        // Invoke the method dynamically
//        functionMap.get("sayHello").invoke(fm); // Outputs: Hello!
//        functionMap.get("greetPerson").invoke(fm, "John"); // Outputs: Hello, John


        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        // Get initial heap memory usage
        MemoryUsage initialHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage initialNONHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

//        System.out.println("Initial Heap Memory Usage: " + initialNONHeapMemoryUsage.getCommitted());
//
//        // Allocate memory by creating a large number of objects
//        ArrayList<String> stringList = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            stringList.add("String number " + i);
//        }
//
//        // Sleep for a moment to allow memory allocation to complete
//        Thread.sleep(2000);
//
//        // Get heap memory usage after creating objects
        MemoryUsage updatedHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Updated Heap Memory Usage: " + updatedHeapMemoryUsage);

    }
}
