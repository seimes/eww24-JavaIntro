package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class ZooManager {
    static Scanner sc;

    public static void read(float[] values) {
        float nextValue = 0;
        for (int i = 0; i < values.length; i++) {
            System.out.print("v: ");
            nextValue = sc.nextFloat();
            if (nextValue == 0f) {
                break;
            }
            values[i] = nextValue;
        }
    }

    public static void print(float[] values) {
        System.out.print("{ ");
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0f) {
                break;
            }
            System.out.printf("%.2f ", values[i]);
        }
        System.out.print("}");
    }

    public static int count(float[] values) {
        int counter = 0;
        while (values[counter] != 0f) {
            counter++;
        }
        return counter;
    }

    public static void clear(float[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0f) {
                break;
            }
            values[i] = 0;
        }
    }

    public static float avg(float[] values) {
        float sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0f) {
                break;
            }
            sum += values[i];
        }

        return sum / count(values);
    }

    public static float b_of_max_a(float[] a, float[] b) {
        if (a.length == 0 && b.length == 0 || a.length != b.length) {
            return -1;
        }

        int maxIndexA = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[maxIndexA]) {
                maxIndexA = i;
            }
        }

        return b[maxIndexA];
    }

    private static void printMenu() {
        System.out.print("-------------------------\n");
        System.out.print("1: Gewicht erfassen\n");
        System.out.print("2: Groesze erfassen\n");
        System.out.print("3: Ausgeben\n");
        System.out.print("4: Angaben pruefen\n");
        System.out.print("5: Loeschen\n");
        System.out.print("6: Durchschn. Gewicht\n");
        System.out.print("7: Durchschn. Groesze\n");
        System.out.print("8: Groesze des Schwersten\n");
        System.out.print("9: Gewicht des Groesten\n");
        System.out.print("0: Beenden\n");
        System.out.print("-------------------------\n");
    }

    private static int readMenu() {
        int m;
        System.out.print(": ");
        m = sc.nextInt();
        return m;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("ZooManager 2.0");
        System.out.println("==============");
        System.out.println();

        printMenu();

        int N = 8;
        float[] weight = new float[N];
        float[] length = new float[N];
        int w;
        int l;

        while(true) {
            switch (readMenu()) {
                case 0:
                    return;
                case 1:
                    read(weight);
                    break;
                case 2:
                    read(length);
                    break;
                case 3:
                    System.out.print("Gewicht: ");
                    print(weight);
                    System.out.print("\nGroesze: ");
                    print(length);
                    System.out.println();
                    break;
                case 4:
                    w = count(weight);
                    l = count(length);
                    System.out.printf("Anzahl: %d/%d\n", w, l);

                    if (w != l) System.out.println("Ungueltig\n");
                    else System.out.println("OK");

                    break;
                case 5:
                    clear(weight);
                    clear(length);
                    break;
                case 6:
                    System.out.printf("Durchschn. Gewicht: %.2f\n", avg(weight));
                    break;
                case 7:
                    System.out.printf("Durchschn. Groesze: %.2f\n", avg(length));
                    break;
                case 8:
                    System.out.printf("Groesze des Schwersten: %.2f\n", b_of_max_a(weight, length));
                    break;
                case 9:
                    System.out.printf("Gewicht des Groesten: %.2f\n", b_of_max_a(length, weight));
                    break;
            }
        }
    }
}
