package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class TimeCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the TimeCalculator!");
        Scanner sc = new Scanner(System.in);
        System.out.print("please enter a duration in milliseconds: ");
        long milliseconds_full = sc.nextLong();

        System.out.printf("%d ms are exactly:\n", milliseconds_full);

        int days_to_milliseconds_factor = 1000 * 60 * 60 * 24;
        int hours_to_milliseconds_factor = 1000 * 60 * 60;
        int minutes_to_milliseconds_factor = 1000 * 60;

        long days = milliseconds_full / days_to_milliseconds_factor;

        long milliseconds_hours_remainder = (milliseconds_full - (days * days_to_milliseconds_factor));
        long hours = milliseconds_hours_remainder / hours_to_milliseconds_factor;

        long milliseconds_minutes_remainder = milliseconds_hours_remainder - (hours * hours_to_milliseconds_factor);
        long minutes = milliseconds_minutes_remainder / minutes_to_milliseconds_factor;

        long milliseconds_seconds_remainder = milliseconds_minutes_remainder - (minutes * minutes_to_milliseconds_factor);
        long seconds = milliseconds_seconds_remainder / 1000;

        long ms = milliseconds_full % 1000;

        String format = "%7s %d\n";
        System.out.printf(format, "days", days);
        System.out.printf(format, "hours", hours);
        System.out.printf(format, "minutes", minutes);
        System.out.printf(format, "seconds", seconds);
        System.out.printf(format, "ms", ms);
    }
}
