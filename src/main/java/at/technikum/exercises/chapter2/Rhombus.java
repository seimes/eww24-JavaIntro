package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Rhombus {
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

        for (int i=0; i<24; i++) {
            System.out.print(i % 10);
        }
        System.out.printf("\n%-11d%s%s%11d", a, "/", "\\", b);
        System.out.printf("\n%-10s%-2s%2s%10s", "", "/", "\\", "");
        System.out.printf("\n%-9s%-3s%3s%9s", "", "/", "\\", "");
        System.out.printf("\n%-8s| %+4.1f |%8s", "", e, "");
        System.out.printf("\n%-9s%-3s%3s%9s", "", "\\", "/", "");
        System.out.printf("\n%-10s%-2s%2s%10s", "", "\\", "/", "");
        System.out.printf("\n%-11d%s%s%11d", c, "\\", "/", d);
    }
}
