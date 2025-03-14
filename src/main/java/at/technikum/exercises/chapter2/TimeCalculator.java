package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class TimeCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the TimeCalculator!");
        Scanner sc = new Scanner(System.in);
        System.out.print("please enter a duration in milliseconds: ");
        long millisecondsFull = sc.nextLong();

        System.out.printf("%d ms are exactly:\n", millisecondsFull);

        int daysToMillisecondsFactor = 1000 * 60 * 60 * 24;
        int hoursToMillisecondsFactor = 1000 * 60 * 60;
        int minutesToMillisecondsFactor = 1000 * 60;

        long days = millisecondsFull / daysToMillisecondsFactor;

        long millisecondsHoursRemainder = (millisecondsFull - (days * daysToMillisecondsFactor));
        long hours = millisecondsHoursRemainder / hoursToMillisecondsFactor;

        long millisecondsMinutesRemainder = millisecondsHoursRemainder - (hours * hoursToMillisecondsFactor);
        long minutes = millisecondsMinutesRemainder / minutesToMillisecondsFactor;

        long millisecondsSecondsRemainder = millisecondsMinutesRemainder - (minutes * minutesToMillisecondsFactor);
        long seconds = millisecondsSecondsRemainder / 1000;

        long ms = millisecondsFull % 1000;

        String format = "%7s %d\n";
        System.out.printf(format, "days", days);
        System.out.printf(format, "hours", hours);
        System.out.printf(format, "minutes", minutes);
        System.out.printf(format, "seconds", seconds);
        System.out.printf(format, "ms", ms);
    }
}
