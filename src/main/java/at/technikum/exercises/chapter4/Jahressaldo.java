package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Jahressaldo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = 1;
        double saldo;
        double total = 0.0;
        double maxSaldo = 0.0;
        double minSaldo = 0.0;

        do {
            System.out.printf("Monat %d: ", month);
            saldo = sc.nextDouble();
            if (month == 1) {
                maxSaldo = saldo;
                minSaldo = saldo;
            }

            if (saldo == 0) {
                System.out.println("Nullsummenspiel.");
            }
            month++;
            total += saldo;
            maxSaldo = Math.max(maxSaldo, saldo);
            minSaldo = Math.min(minSaldo, saldo);

        } while (month <= 12);

        sc.close();
        System.out.printf("Jahressaldo: %.2f%n", total);
        System.out.printf("Groesster Saldo: %.2f%n", maxSaldo);
        System.out.printf("Niedrigster Saldo: %.2f%n", minSaldo);
    }
}
