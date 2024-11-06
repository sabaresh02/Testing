import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UptimeParserLinux {
    public static void main(String[] args) {
        // Sample uptime command output for Linux
        String uptimeOutput = "17:17  up 11 days, 21:25, 6 users, load averages: 2.39 2.75 2.86";
        int totalHours = getUptimeInHours(uptimeOutput);
        System.out.println("Total Uptime in Hours: " + totalHours + " hours");
    }

    public static int getUptimeInHours(String uptimeOutput) {
        Pattern pattern = Pattern.compile("up\\s+(\\d+\\s+days)?\\s*(\\d+):(\\d+)");
        Matcher matcher = pattern.matcher(uptimeOutput);

        int hours = 0;

        if (matcher.find()) {
            String daysPart = matcher.group(1);
            int hourPart = Integer.parseInt(matcher.group(2));
            int minutes = Integer.parseInt(matcher.group(3));

            // Convert days to hours if present
            if (daysPart != null) {
                int days = Integer.parseInt(daysPart.split(" ")[0]);
                hours += days * 24;
            }

            // Add hours and handle minutes rounding
            hours += hourPart;
            if (minutes >= 30) {
                hours++;
            }
        }
        return hours;
    }
}
