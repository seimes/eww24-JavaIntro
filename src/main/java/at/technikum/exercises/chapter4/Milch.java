package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Milch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fettgehalt: ");
        int fat = sc.nextInt();
        System.out.print("Haltbar: ");
        int longLife = sc.nextInt();
        sc.close();

        String classification = "";

        if (fat < 0 || longLife < 0 || longLife > 1) {
            classification = "Ungueltig!";
        }
        else {
            if (longLife == 0) {
                if (fat < 3) {
                    classification = "Leichtmilch (frisch)";
                }
                else if (fat > 7) {
                    classification = "Extravollmilch (frisch)";
                }
                else {
                    classification = "Normalmilch (frisch)";
                }
            } else {
                if (fat < 3) {
                    classification = "Leichtmilch (haltbar)";
                }
                else if (fat > 7) {
                    classification = "Extravollmilch (haltbar)";
                }
                else {
                    classification = "Normalmilch (haltbar)";
                }
            }
        }
        System.out.println(classification);
    }
}
