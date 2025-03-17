package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class MilchFun {
    private static int klasse(double fett, int haltbar) {
        if (fett < 0 || haltbar < 0 || haltbar > 1) {
            return -1;
        }

        if (fett < 3) {
            if (haltbar == 0) return 3;
            else return 4;
        } else if (fett > 7) {
            if (haltbar == 0) return 1;
            else return 2;
        } else {
            if (haltbar == 0) return 5;
            else return 6;
        }
    }

    private static void ausgabe(int k) {
        switch (k) {
            case 1:
                System.out.println("Extravollmilch (frisch)");
                break;
            case 2:
                System.out.println("Extravollmilch (haltbar)");
                break;
            case 3:
                System.out.println("Leichtmilch (frisch)");
                break;
            case 4:
                System.out.println("Leichtmilch (haltbar)");
                break;
            case 5:
                System.out.println("Normalmilch (frisch)");
                break;
            case 6:
                System.out.println("Normalmilch (haltbar)");
                break;
            case -1:
                System.out.println("Ungueltige Klassifizierung!");
                break;
            default:
                System.out.println("Ungueltiges Argument");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fettgehalt: ");
        double fat = sc.nextDouble();
        System.out.print("Haltbar: ");
        int longLife = 0;
        try {
            longLife = sc.nextInt();
        }   catch (Exception e) {
            System.out.println("Haltbarkeit muss entweder 0 oder 1 sein!");
            return;
        }

        ausgabe(klasse(fat, longLife));
    }
}
