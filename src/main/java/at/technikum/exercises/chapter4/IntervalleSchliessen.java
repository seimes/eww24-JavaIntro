package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class IntervalleSchliessen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Grenze 1.1: ");
        int limit1 = sc.nextInt();
        System.out.print("Grenze 1.2: ");
        int limit2 = sc.nextInt();
        System.out.print("Grenze 2.1: ");
        int limit3 = sc.nextInt();
        System.out.print("Grenze 2.2: ");
        int limit4 = sc.nextInt();
        sc.close();

        int min1 = Math.min(limit1, limit2);
        int max1 = Math.max(limit1, limit2);
        int min2 = Math.min(limit3, limit4);
        int max2 = Math.max(limit3, limit4);

        System.out.println("Intervall 1: [" + min1 + ", " + max1 + "]");
        System.out.println("Intervall 2: [" + min2 + ", " + max2 + "]");

        int newMin = Math.min(min1, min2);
        int newMax = Math.max(max1, max2);

        System.out.println("Geschlossenes Intervall: [" + newMin + ", " + newMax + "]");
    }
}
