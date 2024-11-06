import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class CPUMonitor {
    public static void main(String[] args) throws InterruptedException {
        // Get the OperatingSystemMXBean instance
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        // Loop to monitor CPU usage
        for (int ii =0 ;ii <10 ; ii ++) {
//            Thread.sleep(5000);
            // SYSTEM-WIDE CPU LOAD
            // Get system load averages (1, 5, 15 min)

            double systemLoad1Min = osBean.getSystemLoadAverage();  // 1-min load avg
            double systemCpuLoad = osBean.getSystemCpuLoad();       // Total CPU usage

            // JAVA PROGRAM-SPECIFIC CPU USAGE
            double processCpuLoad = osBean.getProcessCpuLoad();     // Java process CPU usage

            // Print system-wide and process-specific CPU load data
            System.out.printf("System CPU Load (1 min avg): %.2f%%%n", systemLoad1Min * 100);
            System.out.printf("System Total CPU Load: %.2f%%%n", systemCpuLoad * 100);
            System.out.printf("Java Program CPU Usage: %.2f%%%n", processCpuLoad * 100);

            // Sleep for a few seconds before checking again (e.g., 5 seconds)
            Thread.sleep(30000);
        }
    }
}
