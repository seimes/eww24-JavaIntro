package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class HundredDoors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        int nDoors = sc.nextInt();
        sc.close();

        boolean[] doors = new boolean[nDoors];
        for (int i = 1; i <= doors.length; i++) {
            for (int j = 1; j <= doors.length; j++) {
                if (j % i == 0) {
                    doors[j - 1] = !doors[j - 1];
                }
            }
        }
        for (int i = 0; i < doors.length; i++) {
            if (doors[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
