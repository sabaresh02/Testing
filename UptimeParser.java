import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UptimeParser {
    public static void main(String[] args) {
        // Sample uptime command output
        String uptimeOutput = "17:17  up 11 days, 21:25, 6 users, load averages: 2.39 2.75 2.86";
        int totalHours = getUptimeInHours(uptimeOutput);
        System.out.println("Total Uptime in Hours: " + totalHours + " hours");
    }

    public static int getUptimeInHours(String uptimeOutput) {
        Pattern pattern = Pattern.compile("up (\\d+) days, (\\d+):(\\d+)");
        Matcher matcher = pattern.matcher(uptimeOutput);

        int hours = 0;

        if (matcher.find()) {
            int days = Integer.parseInt(matcher.group(1));
            int hourPart = Integer.parseInt(matcher.group(2));
            int minutes = Integer.parseInt(matcher.group(3));

            // Convert days to hours and add hour part
            hours = days * 24 + hourPart;
            // Add an extra hour if minutes exceed 30 for an approximate result
            if (minutes >= 30) {
                hours++;
            }
        }
        return hours;
    }
}
