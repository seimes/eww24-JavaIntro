package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Cube {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Length of a side: ");
        int length = sc.nextInt();
        double surface = 6 * length * length;
        double volume = length * length * length;
        System.out.printf("Surface area: %.2f\n", surface);
        System.out.printf("Volume: %.2f", volume);
    }
}
