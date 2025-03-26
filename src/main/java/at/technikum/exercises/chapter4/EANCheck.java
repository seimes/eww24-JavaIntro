package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class EANCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter all 13 digits of an EAN: ");
        long ean = sc.nextLong();
        sc.close();

        System.out.println("EAN: " + ean);

        int even_sum = 0;
        int odd_sum = 0;

        long eanTemp = ean;

        int leadingZeros = 0;
        for (int i = 0; i < 13; i++) {
            if ((((eanTemp / 1000000) / 1000000)) !=  0) {
                break;
            }
            eanTemp *= (int) Math.pow(10, i);
            leadingZeros++;
        }

        for (int i = 12-leadingZeros+2; i > 0 ; i--) {
            if (i % 2 == 0) {
                odd_sum += (int) ((ean % Math.pow(10, i+1)) / Math.pow(10, i));
            }
            else {
                even_sum += (int) ((ean % Math.pow(10, i+1)) / Math.pow(10, i));
            }
        }

        int adjustedTotal = 3 * even_sum + odd_sum - 1;
        int adjustedRemainder = adjustedTotal % 10;
        int checkDigit = 9 - adjustedRemainder;

        if (checkDigit == ean % 10) {
            System.out.println("The EAN is VALID.");
            return;
        }
        System.out.println("The EAN is not VALID.");
    }
}
