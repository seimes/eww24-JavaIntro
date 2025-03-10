package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Hyberbel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        int a = sc.nextInt();
        System.out.print("b: ");
        int b = sc.nextInt();
        System.out.print("c: ");
        int c = sc.nextInt();
        System.out.print("d: ");
        int d = sc.nextInt();
        System.out.print("e: ");
        double e = sc.nextDouble();

        for (int i=0; i<17; i++) {
            System.out.print(i % 10);
        }
        System.out.printf("\n\\%16s", "/");
        System.out.printf("\n%2s %011d / ", "\\" , a);
        System.out.printf("\n%3s %11s", "\\", "/");
        System.out.printf("\n%-3d| %07.3f |%3d", b, e, c);
        System.out.printf("\n%3s %11s", "/", "\\");
        System.out.printf("\n%2s %011d \\ ", "/" , d);
        System.out.printf("\n/%16s", "\\");
    }
}
