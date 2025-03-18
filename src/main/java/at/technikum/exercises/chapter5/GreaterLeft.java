package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class GreaterLeft {
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        int length = sc.nextInt();
        int[] values = new int[length];
        int[] counters = new int[length];

        for (int i = 0; i < length; i++) {
            values[i] = sc.nextInt();
            for (int j = i; j >= 0; j--) {
                if (values[j] > values[i]) {
                    counters[i]++;
                }
            }
        }
        sc.close();

        printArray(counters);
        System.out.println();
        printArray(values);
    }
}
