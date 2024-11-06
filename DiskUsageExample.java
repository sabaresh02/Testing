import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskUsageExample {
    public static void main(String[] args) {
        // Specify the directory to check; use the current working directory if no argument is provided
        String directoryPath = args.length > 0 ? args[0] : System.getProperty("user.dir");

        try {
            // Get the path of the specified directory
            Path path = Paths.get("/Users/sabaresh-17844/Working/dummy/out/production/dummy");
            FileStore fileStore = Files.getFileStore(path);

            // Get the total and usable space
            long totalSpace = fileStore.getTotalSpace();
            long usableSpace = fileStore.getUsableSpace();
            long usedSpace = totalSpace - usableSpace;

            // Print the results
            System.out.printf("Directory: %s%n", directoryPath);
            System.out.printf("Total Space: %d bytes (%.2f GB)%n", totalSpace, totalSpace / (1024.0 * 1024 * 1024));
            System.out.printf("Used Space: %d bytes (%.2f GB)%n", usedSpace, usedSpace / (1024.0 * 1024 * 1024));
            System.out.printf("Usable Space: %d bytes (%.2f GB)%n", usableSpace, usableSpace / (1024.0 * 1024 * 1024));
        } catch (Exception e) {
            System.err.println("Error retrieving disk usage: " + e.getMessage());
        }
    }
}
