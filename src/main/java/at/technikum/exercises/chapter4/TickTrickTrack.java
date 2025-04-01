package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class TickTrickTrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int repetitionCounter = 0;
        int prev = 0;
        int inputCounter = 0;

        do {
            System.out.print("Eingabe: ");
            int number = sc.nextInt();
            if (number == prev) {
                repetitionCounter++;
            } else {
                repetitionCounter = 0;
            }
            if (inputCounter > 0 && repetitionCounter != 2) {
                if (prev > number) {
                    System.out.println("Tick");
                } else if (prev < number) {
                    System.out.println("Trick");
                } else {
                    System.out.println("Track");
                }
            }
            inputCounter++;
            prev = number;
        } while (repetitionCounter != 2);

        System.out.printf("Ende (%d Eingaben)", inputCounter);

        sc.close();
    }
}
