package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Diagonale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int width = 0;

        do {
            System.out.print(": ");
            width = input.nextInt();
        } while (width % 2 == 0 || width < 1);

        input.close();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (i == j || j == width - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
