package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class ReadArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] values = new int[10];

        for (int i = 1; i < 11; i++) {
            System.out.print(i + ". number: ");
            values[i-1] = sc.nextInt();
        }
        System.out.println("Input finished.");

        for (int i = values.length-1; i >= 0; i--) {
            System.out.print("[" + i + "]: " + values[i] + "\n");
        }
        System.out.println("Output finished.");

        sc.close();
    }
}
