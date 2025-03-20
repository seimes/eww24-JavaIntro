package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class Getrimmtesmittel {
    public static int trim(double[] betraege, double min, double max) {
        int counter = 0;
        for (int i = 0; i < betraege.length; i++) {
            if (betraege[i] < min || betraege[i] > max) {
                betraege[i] = 0;
                counter++;
            }
        }
        return counter;
    }

    public static void eingabe(double[] betraege) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= betraege.length; i++) {
            System.out.printf("Zahl %d: ", i);
            betraege[i-1] = sc.nextDouble();
        }
    }

    public static double sum(double[] betraege) {
        double sum = 0;
        for (int i = 0; i < betraege.length; i++) {
            sum += betraege[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        double[] betraege = new double[10];
        eingabe(betraege);
        Scanner sc = new Scanner(System.in);
        System.out.print("Untergrenze: ");
        double min = sc.nextDouble();
        System.out.print("Obergrenze: ");
        double max = sc.nextDouble();

        double sum = sum(betraege);
        int trimCounter = trim(betraege, min, max);
        double trimmedSum = sum(betraege);

        int nonTrimmedCounter = betraege.length - trimCounter;

        System.out.printf("Mittel ungetrimmt: %.2f\n",sum / betraege.length);
        System.out.printf("Mittel getrimmt: %.2f", trimmedSum / nonTrimmedCounter);
        sc.close();
    }
}
