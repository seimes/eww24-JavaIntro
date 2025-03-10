package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class FensterKreuz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width;
        int height;
        int horizontal;
        int vertical;

        do {
            System.out.print("Breite: ");
            width = sc.nextInt();
        } while (width <= 0);

        do {
            System.out.print("Hoehe: ");
            height = sc.nextInt();
        } while (height <= 0);

        do {
            System.out.print("horizontal: ");
            horizontal = sc.nextInt();
        } while (horizontal <= 0 || horizontal > width);

        do {
            System.out.print("vertikal: ");
            vertical = sc.nextInt();
        } while (vertical <= 0 || vertical > height);

        sc.close();

        int dotCount = 0;
        System.out.println();

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                if (col != horizontal && row != vertical) {
                    System.out.print(".");
                    dotCount++;
                } else {
                    if (col == horizontal) {
                        if (row != vertical) {
                            System.out.print("|");
                        } else {
                            System.out.print("+");
                        }
                    } else {
                        System.out.print("-");
                    }
                }
            }
            System.out.println();
        }
        System.out.println(dotCount + " dot(s).");
    }
}
