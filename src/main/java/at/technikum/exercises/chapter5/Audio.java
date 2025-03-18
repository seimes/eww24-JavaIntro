package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class Audio {
    private static float[] increaseArraySize(float[] array, int size) {
        float[] numbersTemp = array;
        array = new float[size];
        for (int i = 0; i < numbersTemp.length; i++) {
            array[i] = numbersTemp[i];
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Max. 16 Werte eingeben, 0 beendet:");
        int counter = 0;
        float[] values = new float[0];

        while(counter < 16) {
            float currentValue = sc.nextFloat();
            if (currentValue == 0.0f) {
                break;
            } else if (currentValue > 0.0f) {
                currentValue = 0.0f;
            } else if (currentValue < -100.0) {
                currentValue = -100.0f;
            }
            values = increaseArraySize(values, counter + 1);
            values[counter] = currentValue;
            counter++;
        }

        System.out.println("Eingelesen: " + counter);
        System.out.print("N: ");
        int n = sc.nextInt();
        if (n > values.length) {
            System.out.println("Zu wenige Werte");
            return;
        }

        float meanN = 0f;
        for (int i = values.length-n; i < values.length; i++) {
            meanN += values[i];
        }
        meanN /= n;

        System.out.printf("Wert = %.2f", meanN);
        sc.close();
    }
}
