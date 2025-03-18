package at.technikum.exercises.chapter5;
import java.util.Scanner;

public class ArrayEvenStatistics {
    private static int[] increaseArraySize(int[] array, int size) {
        int[] numbersTemp = array;
        array = new int[size];
        for (int i = 0; i < numbersTemp.length; i++) {
            array[i] = numbersTemp[i];
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[1];
        int counter = 0;

        System.out.println("Input");

        int countEven = 0;
        String evenPositions = "[";
        String maxPositions = evenPositions;
        int evenSum = 0;
        int evenMax = 0;

        while (counter < 1024) {
            System.out.print(": ");
            int currentNumber = sc.nextInt();
            if (currentNumber == 0) {
                System.out.print("re-enter 0 to store as value.\nany other value ends input: ");
                int next = sc.nextInt();
                if (next != 0) {
                    break;
                }
                System.out.println("value 0 stored.");
            }

            numbers = increaseArraySize(numbers, counter + 1);

            if (currentNumber % 2 == 0) {
                countEven++;
                evenPositions += " " + counter;
                evenSum += currentNumber;
                if (evenMax < currentNumber) {
                    evenMax = currentNumber;
                }
            }
            numbers[counter] = currentNumber;
            counter++;
        }
        evenPositions += "]";

        for (int i = 0; i < numbers.length; i++) {
            if (evenMax == numbers[i]) {
                maxPositions += " " + i;
            }
        }
        maxPositions += "]";

        if (counter > 0) {
            System.out.println("Input finished");
            System.out.printf("%15s: %d", "count", countEven);
            if (countEven > 0) {
                System.out.printf("\n%15s: %s", "index positions", evenPositions);
                System.out.printf("\n%15s: %d", "sum", evenSum);
                System.out.printf("\n%15s: %.2f", "mean", (double) evenSum / countEven);
                System.out.printf("\n%15s: %d %s", "max", evenMax, maxPositions);
            }
        } else {
            System.out.println("no value entered");
        }
        sc.close();
    }
}
