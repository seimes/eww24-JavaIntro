package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Datum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Datum: ");
        int date = sc.nextInt();

        int year = date % 10000;
        int month = (date / 10000) % 100;
        int day = (date / (1000*1000));

        if (day < 1 || day > 31) {
            System.out.println("Tag muss zwischen 1 und 31 liegen!");
        } else if (month < 1 || month > 12) {
            System.out.println("Monat muss zwischen 1 und 12 liegen!");
        } else if (year <= 1582) {
            if (year < 1581) {
                System.out.println("Jahr muss groesser als 1581 sein!");
            } else {
                if (month <= 10) {
                    if (day < 14) {
                        System.out.println("Datum muss nach dem 14.10.1582 liegen!");
                    }
                }
            }
        }
        else {
            String monthName = switch (month) {
                case 1 -> "Januar";
                case 2 -> "Februar";
                case 3 -> "Maerz";
                case 4 -> "April";
                case 5 -> "Mai";
                case 6 -> "Juni";
                case 7 -> "Juli";
                case 8 -> "August";
                case 9 -> "September";
                case 10 -> "Oktober";
                case 11 -> "November";
                case 12 -> "Dezember";
                default -> "";
            };
            System.out.printf("%s. %s. %s", day, monthName, year);
        }
    }
}
