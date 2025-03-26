package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Noten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Noten: ");
        String gradesString = sc.next();
        sc.close();

        int grades = Integer.parseInt(gradesString);

        int grade1 = grades % 10;
        int grade2 = (grades % 100) / 10;
        int grade3 = grades / 100;

        if (gradesString.length() != 3 && grade3 >= 0) {
            System.out.println("Erwarte genau 3 Noten!");
            return;
        }

        if (grade3 < 1 || grade3 > 5) {
            System.out.println("Erste Note muss zwischen 1 und 5 liegen!");
            return;
        }
        if (grade2 < 1 || grade2 > 5) {
            System.out.println("Zweite Note muss zwischen 1 und 5 liegen!");
            return;
        }
        if (grade1 < 1 || grade1 > 5) {
            System.out.println("Dritte Note muss zwischen 1 und 5 liegen!");
            return;
        }

        int gradeSum = grade1 + grade2 + grade3;
        if (gradeSum == 3) {
            System.out.println("Ausgezeichneter Erfolg!");
            return;
        }
        if (gradeSum == 4) {
            System.out.println("Guter Erfolg!");
            return;
        }
        if (grade1 == 5 || grade2 == 5 || grade3 == 5) {
            System.out.println("Nicht bestanden!");
            return;
        }

        System.out.println("Bestanden.");
    }
}
