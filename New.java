import java.io.File;

public class New {
    public static void main(String[] args) {
        // Get all available filesystem roots
        File[] roots = File.listRoots();

        // Iterate through each root and print its size information
        for (File root : roots) {
            // Get total space, usable space, and free space
            long totalSpace = root.getTotalSpace();
            long usableSpace = root.getUsableSpace();
            long freeSpace = root.getFreeSpace();

            // Convert bytes to gigabytes for easier readability
            double totalSpaceGB = totalSpace / (1024.0 * 1024.0 * 1024.0);
            double usableSpaceGB = usableSpace / (1024.0 * 1024.0 * 1024.0);
            double freeSpaceGB = freeSpace / (1024.0 * 1024.0 * 1024.0);

            // Print the drive information
            System.out.printf("Drive: %s%n", root.getAbsolutePath());
            System.out.printf("Total Space: %.2f GB%n", totalSpaceGB);
            System.out.printf("Usable Space: %.2f GB%n", usableSpaceGB);
            System.out.printf("Free Space: %.2f GB%n", freeSpaceGB);
            System.out.println("-----------------------------------");
        }
    }
}
