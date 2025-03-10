package at.technikum.exercises.chapter3;

import java.util.Scanner;

public class Swapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first number (a): ");
        int a = sc.nextInt();
        System.out.print("enter second number (b): ");
        int b = sc.nextInt();

        System.out.printf("a=%d, b=%d\n", a, b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("swapped:");
        System.out.printf("a=%d, b=%d\n", a, b);
    }
}
