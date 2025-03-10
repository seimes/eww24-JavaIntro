package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Age_of_Empires {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your age: ");
        int age = sc.nextInt();

        System.out.printf("%-5s ~%d~\n", "%d:", age);
        System.out.printf("%-5s ~%+d~\n", "%+d:", age);
        System.out.printf("%-5s ~% d~\n", "% d:", age);
        System.out.printf("%-5s ~%5d~\n", "%5d:", age);
        System.out.printf("%-5s ~%05d~\n", "%05d:", age);
        System.out.printf("%-5s ~%-5d~\n", "%-5d:", age);
        System.out.printf("%-5s ~%#x~\n", "%#x:", age);
    }
}
