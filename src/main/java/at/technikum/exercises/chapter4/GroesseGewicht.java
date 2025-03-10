package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class GroesseGewicht {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Groesse: ");
        int height = sc.nextInt();
        System.out.print("Gewicht: ");
        int weight = sc.nextInt();
        sc.close();

        String classification = "";

        if (height > 0 && weight > 0) {
            if (weight <= 90) {
                if (height <= 200) {
                    classification = "normal";
                } else {
                    classification = "hager";
                }
            } else {
                if (height <= 200) {
                    classification = "uebergewichtig";
                } else {
                    classification = "riesig";
                }
            }
            if (height < 50 || weight > 200) {
                classification += " (*)";
            }
        } else {
            classification = "Ungueltig!";
        }

        System.out.println(classification);
    }
}
