package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class RoboterSteuerung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Art: ");
        int art = 5;

        do {
            art = sc.nextInt();
            switch (art) {
                case 1:
                    System.out.print(1 + ": ");
                    double value = sc.nextDouble();
                    System.out.printf("Abstand vorne: %.2f m\n", value);
                    if (value < 0 || value > 10) {
                        System.out.println("** Fehler: Wertebereich");
                        return;
                    }
                    break;
                case 2:
                    System.out.print(1 + ": ");
                    value = sc.nextDouble();
                    System.out.printf("Abstand hinten: %.2f m\n", value);
                    if (value < 0 || value > 10) {
                        System.out.println("** Fehler: Wertebereich");
                        return;
                    }
                    break;
                case 3:
                    String output = "Gyroskop: (";
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(i + ": ");
                        value = sc.nextDouble();
                        if (value < -250 || value > 250) {
                            System.out.println("** Fehler: Wertebereich");
                            return;
                        }
                        if (i != 3) {
                            output += String.format("%.2f, ", value);
                        } else {
                            output += String.format("%.2f) g", value);
                        }
                    }
                    System.out.println(output);
                    break;
                case 4:
                    output = "Magnetometer (";
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(i + ": ");
                        value = sc.nextDouble();
                        if (value < 0 || value > 1) {
                            System.out.println("** Fehler: Wertebereich");
                            return;
                        }
                        if (i != 3) {
                            output += String.format("%.2f, ", value);
                        } else {
                            output += String.format("%.2f) T", value);
                        }
                    }
                    System.out.println(output);
                    break;
            }
        } while (art != 0);

        sc.close();
    }
}
