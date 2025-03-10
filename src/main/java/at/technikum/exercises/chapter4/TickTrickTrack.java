package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class TickTrickTrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = 0;
        int prev = 0;
        boolean firstIteration = true;
        int inputCounter = 0;

        do {
            System.out.print("Eingabe: ");
            int number = sc.nextInt();
            if (number == prev) {
                counter++;
            } else {
                counter = 0;
            }
            if (!firstIteration && counter != 2) {
                if (prev > number) {
                    System.out.println("Tick");
                } else if (prev < number) {
                    System.out.println("Trick");
                } else {
                    System.out.println("Track");
                }
            }
            firstIteration = false;
            inputCounter++;
            prev = number;
        } while (counter != 2);

        System.out.printf("Ende (%d Eingaben)", inputCounter);

        sc.close();
    }
}
