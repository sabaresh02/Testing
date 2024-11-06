import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class TotalRamUsage {
    public static void main(String[] args) {
        // Get the OperatingSystemMXBean instance
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        // Get total physical memory size
        long totalPhysicalMemory = osBean.getTotalPhysicalMemorySize();

        System.out.println(osBean.getProcessCpuLoad());
        System.out.println(osBean.getProcessCpuLoad());
        // Get used physical memory
        long usedPhysicalMemory = totalPhysicalMemory - osBean.getFreePhysicalMemorySize();

        // Convert bytes to megabytes
        double totalPhysicalMemoryMB = totalPhysicalMemory / (1024.0 * 1024.0);
        double usedPhysicalMemoryMB = usedPhysicalMemory / (1024.0 * 1024.0);

        // Print the results
        System.out.printf("Total Physical Memory: %.2f MB%n", totalPhysicalMemoryMB);
        System.out.printf("Used Physical Memory: %.2f MB%n", usedPhysicalMemoryMB);
    }
}
