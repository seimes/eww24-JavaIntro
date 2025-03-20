package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class PartyHandshake {
    static Scanner sc;

    public static String[] readNames(int n) {
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        return names;
    }

    public static String[] handShakes(String[] names) {
        /*
            4 + 3 + 2 + 1 = 10, n=5, 4*5/2 = 10
            5 + 4 + 3 + 2 + 1 = 15, n = 6, 5*6/2 = 15
            6 + 5 + 4 + 3 + 2 + 1 = 21, n = 7, 6*7/2 = 21
            7 + 6 + 5 + 4 + 3 + 2 + 1 = 28, n=8, 7*8/2 = 28
            ...
            number of discharges = ((n-1)*n)/2 (=Gausssche Summenformel)
         */
        int n = (names.length-1)*names.length/2;
        String[] discharges = new String[n];
        int count = 0;
        for (int i = 0; i < names.length; i++) {
            for (int j = i+1; j < names.length; j++) {
                System.out.println("j-1: " + (j-1));
                discharges[count] = names[i] + " -> " + names[j];
                count++;
            }
        }
        return discharges;
    }

    public static void print(String[] stra) {
        for (int i = 0; i < stra.length; i++) {
            System.out.println(stra[i]);
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf(": ");
        int n = sc.nextInt();
        String[] names = readNames(n);
        String[] handshakes = handShakes(names);
        print(handshakes);
        sc.close();
    }
}
