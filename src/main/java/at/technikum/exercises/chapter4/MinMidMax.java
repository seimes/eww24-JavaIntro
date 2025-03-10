package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class MinMidMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie drei Zahlen ein: ");
        System.out.print("a : ");
        int a = sc.nextInt();
        System.out.print("b : ");
        int b = sc.nextInt();
        System.out.print("c : ");
        int c = sc.nextInt();
        sc.close();

        /*int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int mid = */
        if (a < b) {
            if (b < c) {
                System.out.println(a + " < " + b + " < " + c);
                System.out.println("a < b  < c");
            }
            else {
                if (b == c) {
                    System.out.println(a + " < " + b + " = " + c);
                    System.out.println("a < b = c");
                } else {
                    if (a < c) {
                        System.out.println(a + " < " + c + " < " + b);
                        System.out.println("a < c < b");
                    } else {
                        if (a == c) {
                            System.out.println(a + " = " + c + " < " + b);
                            System.out.println("a = c < b");
                        }
                        else {
                            System.out.println(c + " < " + a + " < " + b);
                            System.out.println("c < a < b");
                        }
                    }
                }
            }
        }  else { // a >= b
            if (a == b) {
                if (b < c) {
                    System.out.println(a + " = " + b + " < " + c);
                    System.out.println("a = b < c");
                } else {
                    if (b == c) {
                        System.out.println(a + " = " + b + " = " + c);
                        System.out.println("a = b = c");
                    } else {
                        System.out.println(c + " < " + a + " = " + b);
                        System.out.println("c < a = b");
                    }
                }
            } else { // a > b
                if (a < c) {
                    System.out.println(b + " < " + a + " < " + c);
                    System.out.println("b < a < c");
                } else {
                    if (a == c) {
                        System.out.println(b + " < " + a + " = " + c);
                        System.out.println("b < a = c");
                    } else {
                        System.out.println(b + " < " + c + " < " + a);
                        System.out.println("b < c < a");
                    }
                }
            }
        }
    }
}
