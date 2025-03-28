package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class RoboterSteuerung {
    private static boolean checkValues(int min, int max, double value) {
        if (value < min ||  value > max) {
            System.out.println("** Fehler: Wertebereich");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int art;

        do {
            System.out.print("Art: ");
            art = sc.nextInt();
            double value;
            switch (art) {
                case 1:
                    System.out.print(1 + ": ");
                    value = sc.nextDouble();
                    System.out.printf("Abstand vorne: %.2f m\n", value);
                    if(!checkValues(0, 10, value)) return;
                    break;
                case 2:
                    System.out.print(1 + ": ");
                    value = sc.nextDouble();
                    System.out.printf("Abstand hinten: %.2f m\n", value);
                    if(!checkValues(0, 10, value)) return;
                    break;
                case 3:
                    String output = "Gyroskop: (";
                    for (int i = 1; i <= 3; i++) {
                        System.out.print(i + ": ");
                        value = sc.nextDouble();
                        if(!checkValues(-250, 250, value)) return;

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
                        if(!checkValues(0, 1, value)) return;
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
