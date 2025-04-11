package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class TimeCalculations {
    private static int encode(int h, int m) {
        return h * 100 + m;
    }

    private static int read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("hours: ");
        int hours = sc.nextInt();
        System.out.print("minutes: ");
        int minutes = sc.nextInt();

        return encode(hours, minutes);
    }

    private static int hours(int t) {
        return t / 100;
    }

    private static int minutes(int t) {
        return t % 100;
    }

    private static void print(int t) {
        System.out.printf("%02d:%02d", hours(t), minutes(t));
    }

    private static int add(int t1, int t2) {
        int min1 = minutes(t1);
        int min2 = minutes(t2);
        int hours1 = hours(t1);
        int hours2 = hours(t2);

        int min = min1 + min2;
        int hour = (hours1 + hours2) % 24;

        /*if (min >= 60) {
            hour += 1;
        }*/
        hour += min / 60;

        return encode(hour, min % 60);
    }

    private static int totalMinutes(int t) {
        int hours = hours(t);
        int min = minutes(t);

        return hours * 60 + min;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int time1 = read();
            int time2 = read();

            print(time1);
            System.out.print(" + ");
            print(time2);
            System.out.print(" = ");
            print(add(time1, time2));
            System.out.println();

            System.out.println("Minutes since midnight: " + totalMinutes(time1));
            System.out.println("Minutes since midnight: " + totalMinutes(time2));
            System.out.println();
        }
    }
}
