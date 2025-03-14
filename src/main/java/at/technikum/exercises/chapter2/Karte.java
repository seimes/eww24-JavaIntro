package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Karte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter an integer: ");
        int input = scanner.nextInt();
        scanner.close();

        System.out.printf("%-5d /\\ %5d\n", input, input);
        System.out.printf("%-+5d /\\ %+5d", input, input);
    }
}
