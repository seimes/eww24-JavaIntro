package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class Handytarif {
    private static double BASE_RATE = 5.99;
    private static double PHONE_RATE = 0.99;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("min: ");
        int mins = sc.nextInt();
        System.out.print("SMS: ");
        int smsCount = sc.nextInt();
        double phoneSum = 0;
        sc.close();

        if (mins >= 0 && smsCount >= 0) {
            if (mins > 100) phoneSum = (mins - 100) * PHONE_RATE;

            double smsCosts = 0;

            if (smsCount >= 1 && smsCount <= 10) {
                smsCosts = 0.05 * smsCount;
            } else if (smsCount >= 11 && smsCount <= 20) {
                smsCosts = 0.5 + 0.04 * (smsCount - 10);
            } else if (smsCount >= 21 && smsCount <= 50) {
                smsCosts = 0.9 + 0.03 * (smsCount - 20);
            } else if (smsCount >= 51 && smsCount <= 100) {
                smsCosts = 1.8 + 0.02 * (smsCount - 50);
            } else if (smsCount >= 101 && smsCount <= 1000) {
                smsCosts = 2.8 + 0.01 * (smsCount - 100);
            } else if (smsCount > 1000) {
                smsCosts = 11.8 + 0.005 * (smsCount - 1000);
            }

            System.out.printf("zu bezahlen: %.2f + %.2f + %.2f = %.2f\n", BASE_RATE, phoneSum, smsCosts, BASE_RATE + phoneSum + smsCosts);
        } else {
            System.out.println("ungueltig.");
        }
    }
}
