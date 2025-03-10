package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Zahlendreher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zahl: ");
        int number = sc.nextInt();

        int firstDigit = number / 100;
        int secondDigit = (number % 100) / 10;
        int thirdDigit = number % 10;

        System.out.printf("Ausgabe: %d%d%d", thirdDigit, secondDigit, firstDigit);
    }
}
