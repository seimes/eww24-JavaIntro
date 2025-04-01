package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Walker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 10;
        int yPos = size - 1;
        int xPos = 0;
        //int number;
        char input;
        int steps = 0;

        do {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == yPos && j == xPos) {
                        System.out.print("X");
                    }
                    else {
                        System.out.print(".");
                    }
                }
                System.out.println("");
            }

            System.out.print("\nEingabe: ");
            //number = sc.nextInt();
            input = sc.next("[a-zA-Z0-9]").charAt(0);

            boolean impossible = false;
            boolean unknown = false;
            if (input == '8' || input == 'w') {
                if (yPos > 0) {
                    yPos--;
                } else {
                    impossible = true;
                }
            } else if (input == '6' || input == 'd') {
                if (xPos < size-1) {
                    xPos++;
                } else {
                    impossible = true;
                }
            } else if (input == '2' || input == 's') {
                if (yPos < size-1) {
                    yPos++;
                } else {
                    impossible = true;
                }
            } else if (input == '4' || input == 'a') {
                if (xPos > 0) {
                    xPos--;
                } else {
                    impossible = true;
                }
            } else if (input == '5' || input == 'q') {
                System.out.printf("Schritte insgesamt: %d", steps);
            } else {
                unknown = true;
            }
            if (impossible) {
                System.out.println("Aktion unmoeglich!");
            } else if (unknown) {
                System.out.println("Unbekannte Aktion!");
            } else {
                steps++;
            }
        } while (input != '5' && input != 'q');
        sc.close();
    }
}
