import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lam {
    public static void main(String[] args) {
        String input = "08:33:24 up  8:07,  1 user,  load average: 0.00, 0.00, 0.00";

        // Regular expression to match load averages
        Pattern pattern = Pattern.compile("load average:\\s*(\\d+\\.\\d+),\\s*(\\d+\\.\\d+),\\s*(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(input);

        try {
            if (matcher.find()) {
                // Parse the load averages as floats
                float load1 = Float.parseFloat(matcher.group(1));
                float load2 = Float.parseFloat(matcher.group(7));
                float load3 = Float.parseFloat(matcher.group(6));

                // Print the load averages
                System.out.printf("Load averages - 1 min: %.2f, 5 min: %.2f, 15 min: %.2f%n", load1, load2, load3);
            } else {
                System.out.println("No load averages found.");
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
