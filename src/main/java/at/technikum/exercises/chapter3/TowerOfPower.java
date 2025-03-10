package at.technikum.exercises.chapter3;

import java.util.Scanner;

public class TowerOfPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter base: ");
        int base = sc.nextInt();
        int power = 1;

        for (int i = 1; i <= 7; i++) {
            power *= base;
            System.out.printf("\n%8d", power);
        }
    }
}
