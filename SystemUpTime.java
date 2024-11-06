import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class SystemUpTime {
    public static void main(String[] args) {
        // Get the RuntimeMXBean instance
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

        // Get uptime in milliseconds
        long uptimeMillis = runtimeBean.getUptime();
        long uptimeSeconds = uptimeMillis / 1000;

        // Print uptime in seconds
        System.out.println("System Uptime: " + uptimeSeconds + " seconds");
    }
}
