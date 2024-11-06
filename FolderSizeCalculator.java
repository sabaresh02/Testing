import java.io.File;

public class FolderSizeCalculator {

    public static void main(String[] args) {
        String folderPath = "/Users/sabaresh-17844/Git/Agent/java/temp/zoho-iot-edge-agent-java/dist/data/edge_agent_system.db";
        File folder = new File(folderPath);
        double folderSize = getFolderSize(folder)/(1024.0 *1024.0);
        System.out.printf("%.8f%n", folderSize);

    }
    private static long getFolderSize(File folder) {
        long size = 0;
        if (folder.exists() && folder.isDirectory() &&  folder.listFiles()!= null) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    size += getFolderSize(file);
                } else {
                    size += file.length();
                }
            }

        }

        if(folder.exists() && folder.isFile()){
            size += folder.length();
        }
        return size;
    }
}
