package at.technikum.exercises.chapter3;

import java.util.Scanner;

public class SwapInPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        int a = sc.nextInt();
        System.out.print(" ");
        int b = sc.nextInt();

        System.out.println("Before:");
        System.out.println(" a= " + a);
        System.out.println(" b= " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After:");
        System.out.println(" a= " + a);
        System.out.println(" b= " + b);
    }
}
