//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//
//public class SigarLoadAverage {
//    public static void main(String[] args) {
//        try {
//            // Create Sigar instance
//            Sigar sigar = new Sigar();
//
//            // Get system load averages (1, 5, 15 minutes)
//            double[] loadAverages = sigar.getLoadAverage();
//
//            // Print load averages
//            System.out.println("Load Averages (1 min, 5 min, 15 min): ");
//            System.out.printf("1 min: %.2f, 5 min: %.2f, 15 min: %.2f%n",
//                    loadAverages[0], loadAverages[1], loadAverages[2]);
//
//        } catch (SigarException e) {
//            e.printStackTrace();
//        }
//    }
//}
