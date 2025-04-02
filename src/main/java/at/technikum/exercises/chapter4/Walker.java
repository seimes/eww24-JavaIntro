package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Walker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 10;
        int yPos = size - 1;
        int xPos = 0;
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
                System.out.println();
            }

            System.out.print("\nEingabe: ");
            input = sc.next("[a-zA-Z0-9]").charAt(0);

            boolean impossible = false;
            boolean unknown = false;

            switch(input) {
                case '8', 'w', 'k':
                    if (yPos > 0) yPos--;
                    else impossible = true;

                    break;
                case '6', 'd', 'l':
                    if (xPos < size-1) xPos++;
                    else impossible = true;

                    break;
                case '2', 's', 'j':
                    if (yPos < size-1) yPos++;
                    else impossible = true;

                    break;
                case '4', 'a', 'h':
                    if (xPos > 0) xPos--;
                    else impossible = true;

                    break;
                case '5', 'q':
                    System.out.printf("Schritte insgesamt: %d", steps);
                    break;
            default:
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
