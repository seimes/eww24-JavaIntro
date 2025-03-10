package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Geburtsdatum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Geburtsdatum: ");
        int date = sc.nextInt();
        // DDMMJJ -> JJMMDD
        int year = date % 100;
        int month = (date / 100) % 100;
        int day = date / 10000;

        System.out.printf("%02d%02d%02d", year, month, day);
    }
}
