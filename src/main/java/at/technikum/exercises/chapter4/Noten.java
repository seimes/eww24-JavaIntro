package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Noten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Noten: ");
        int grades = sc.nextInt();
        sc.close();

        int grade1 = grades % 10;
        int grade2 = (grades % 100) / 10;
        int grade3 = grades / 100;

        System.out.println(grade3);

        String output = "";

        if (grade3 > 9 || grade3 <= 0) {
            output = "Erwarte genau 3 Noten!";
        } else {
            if (grade3 < 1 || grade3 > 5) {
                output = "Erste Note muss zwischen 1 und 5 liegen!";
            } else if (grade2 < 1 || grade2 > 5) {
                output = "Zweite Note muss zwischen 1 und 5 liegen!";
            } else if (grade1 < 1 || grade1 > 5) {
                output = "Dritte Note muss zwischen 1 und 5 liegen!";
            } else {
                int gradeSum = grade1 + grade2 + grade3;
                if (gradeSum == 3) {
                    output = "Ausgezeichneter Erfolg!";
                } else if (gradeSum == 4) {
                    output = "Guter Erfolg!";
                } else if (grade1 == 5 || grade2 == 5 || grade3 == 5) {
                    output = "Nicht bestanden!";
                } else {
                    output = "Bestanden.";
                }
            }
        }

        System.out.println(output);
    }
}
