package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class DateFormatConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter date (yyyymmdd)");
        int date = sc.nextInt();

        if (date < 15821016 || date > 21001231) {
            System.out.println("invalid date");
            return;
        }

        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;
        System.out.printf("%02d.%02d.%4d", day, month, year);
    }
}
