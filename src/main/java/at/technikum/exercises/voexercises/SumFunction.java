package at.technikum.exercises.voexercises;

import java.util.Scanner;

public class SumFunction {
    private static int arraySum(int[] arr) {
        int sum = 0;

        for(int a : arr) {
            sum += a;
        }
        return sum;
    }

    private static void printArray(int[] arr) {
        String output = "{";
        for (int i=0; i < arr.length; i++) {
            output += arr[i];
            if (i < arr.length - 1) output += ", ";
        }
        output += "}";

        System.out.println(output);
    }

    public static void main(String[] args){
        int[] numbers = {2, 3, 5, -3, 7, 9, 0, -3, 40, 6};

        printArray(numbers);
        System.out.println(arraySum(numbers));
    }
}
