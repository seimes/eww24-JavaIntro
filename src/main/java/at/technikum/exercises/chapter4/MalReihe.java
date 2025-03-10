package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class MalReihe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fixFactor;
        int limitFactor;

        do {
            System.out.print("Fixfaktor: ");
            fixFactor = sc.nextInt();
        }
        while (fixFactor < -10 || fixFactor > 10 || fixFactor == 0);

        do {
            System.out.print("Grenzfaktor: ");
            limitFactor = sc.nextInt();
        }
        while (limitFactor < 1 || limitFactor > 10);

        sc.close();

        for (int i = 1; i <= limitFactor; i++) {
            System.out.println(i + " x   " + fixFactor + " = " + fixFactor * i);
        }
    }
}
