package test;

import java.time.Duration;
import java.time.Instant;

public class TimeDef {
    public static void main(String[] args) {
        int pollingInterval = 20; // Set your interval in seconds

        Instant lastPollTime = Instant.now();
        System.out.println("Current Time: " + lastPollTime);

        // Subtract the polling interval
        lastPollTime = lastPollTime.minusSeconds(pollingInterval);
        System.out.println("Updated Time after subtracting interval: " + lastPollTime);

        // Calculate the time difference from the current time
        Instant currentTime = Instant.now();
        Duration duration = Duration.between(lastPollTime, currentTime);

        System.out.println("Time difference: " + duration.getSeconds() + " seconds");
    }
}
