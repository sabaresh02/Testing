import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class WindowsUptime {
    public static void main(String[] args) {
        // Input date string in the format given
        String inputDateTime = "10/28/2024, 1:38:19 AM";

        // Define the formatter for the exact pattern in the input with Locale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, h:mm:ss a", Locale.ENGLISH);

        try {
            // Parse the input string to LocalDateTime
            LocalDateTime parsedDateTime = LocalDateTime.parse(inputDateTime, formatter);

            // Get the current date-time
            LocalDateTime now = LocalDateTime.now();

            // Calculate the duration between parsedDateTime and now
            Duration duration = Duration.between(parsedDateTime, now);
            long hours = duration.toHours();

            // Print the uptime in hours
            System.out.println("Uptime in hours: " + hours);
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date-time: " + e.getMessage());
        }
    }
}
