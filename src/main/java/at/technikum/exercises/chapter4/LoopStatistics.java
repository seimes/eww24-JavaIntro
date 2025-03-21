package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class LoopStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter numbers: ");
        double number;
        double min = 0;
        double max = 0;
        double mean;
        double sum = 0;
        int count = 0;

        do {
            number = scanner.nextDouble();
            if (count == 0) {
                if (number <= 0) {
                    System.out.println("no number entered.");
                    return;
                }
                min = number;
                max = number;
            }
            if (number > 0) {
                count++;
                sum += number;

                max = Math.max(max, number);
                min = Math.min(min, number);
            }
        } while (number > 0);

        mean = sum / count;

        System.out.println("numbers entered: " + count);
        System.out.printf("\nminimum: %.2f", min);
        System.out.printf("\nmaximum: %.2f", max);
        System.out.printf("\nmean: %.2f", mean);
    }
}
