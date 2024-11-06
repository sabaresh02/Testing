import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class La{
    public static void main(String[] args) {
        String input = "17:17  up 11 days, 21:25, 6 users, load averages: 2.39 2.75 2.86";
//        String input = "08:33:24 up  8:07,  1 user,  load average: 0.00, 0.00, 0.00";

        // Regex to capture the load averages
        Pattern pattern = Pattern.compile("load averages:\\s+(\\d+\\.\\d+)\\s+(\\d+\\.\\d+)\\s+(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Parse the load averages as floats
            float load1 = Float.parseFloat(matcher.group(1));
            float load2 = Float.parseFloat(matcher.group(2));
            float load3 = Float.parseFloat(matcher.group(3));

            System.out.printf("Load averages: 1 min: %.2f, 5 min: %.2f, 15 min: %.2f%n", load1, load2, load3);
        } else {
            System.out.println("No load averages found.");
        }
    }
}
