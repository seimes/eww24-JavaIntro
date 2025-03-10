package at.technikum.exercises.chapter2;

import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an amount: ");
        double amount = Double.parseDouble(sc.nextLine());

        double amountWithTax = amount * 1.2;

        System.out.printf("With tax added: %.2f", amountWithTax);
    }
}
