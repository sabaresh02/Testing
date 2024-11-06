import java.io.File;

public class DiskSpaceInfo {
    public static void main(String[] args) {
        // Specify the path of the drive or directory you want to check
        File file = new File("/"); // Use "/" for Linux/macOS or "C:\\" for Windows

        // Get total disk space
        long totalSpace = file.getTotalSpace(); // Total disk space in bytes
        // Get usable disk space
        long usableSpace = file.getUsableSpace(); // Usable disk space in bytes
        // Get free disk space
        long freeSpace = file.getFreeSpace(); // Free disk space in bytes

        // Convert bytes to gigabytes for easier readability
        double totalSpaceGB = totalSpace / (1024.0 * 1024.0 * 1024.0);
        double usableSpaceGB = usableSpace / (1024.0 * 1024.0 * 1024.0);
        double freeSpaceGB = freeSpace / (1024.0 * 1024.0 * 1024.0);

        // Print the results
        System.out.printf("Total Disk Space: %.2f GB%n", totalSpaceGB);
        System.out.printf("Usable Disk Space: %.2f GB%n", usableSpaceGB);
        System.out.printf("Free Disk Space: %.2f GB%n", freeSpaceGB);
    }
}
