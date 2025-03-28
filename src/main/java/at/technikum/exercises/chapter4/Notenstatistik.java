package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Notenstatistik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Noteneingabe:");
        int grade = 1;
        int negativeCount = 0;
        int gradeCount = 0;
        double sum = 0;

        do {
            System.out.print(": ");
            grade = sc.nextInt();
            if (grade < 0 || grade > 5) {
                System.out.println("Falsche Eingabe");
                continue;
            }

            if (grade == 5) negativeCount++;

            sum += grade;

            if (grade != 0) gradeCount++;

        } while (grade != 0);

        sc.close();
        System.out.printf("Notendurchschnitt: %.2f Anzahl Fuenfer: %d", sum / gradeCount, negativeCount);
    }
}
