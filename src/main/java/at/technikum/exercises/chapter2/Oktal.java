package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Oktal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Oktalzahl eingeben: ");
        int octal = sc.nextInt();

        int firstDigit = octal / 100;
        int secondDigit = (octal % 100) / 10;
        int thirdDigit = octal % 10;

        int decimal = (firstDigit * 8*8) + (secondDigit * 8) + thirdDigit;

        int decimal_first = decimal / 100;
        int decimal_second = (decimal % 100) / 10;
        int decimal_third = decimal % 10;

        int digit_sum = decimal_first + decimal_second + decimal_third;

        System.out.println("dezimal: " + decimal);
        System.out.println("Ziffernsumme: " + digit_sum);
    }
}
