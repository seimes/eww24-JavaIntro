package at.technikum.exercises.chapter5;

import java.util.Scanner;

public class BMI {
    public static double bmiCalc(double height, double weight) {
        if (weight < 40 || height < 1.6) {
            return -1;
        }

        return weight / (height * height);
    }

    public static int bmiCategory(double bmi) {
        if (bmi >= 0) {
            if (bmi < 15) {
                return 10;
            } else if (bmi < 16) {
                return 11;
            } else if (bmi < 18.5) {
                return 12;
            } else if (bmi < 25) {
                return 20;
            } else if (bmi < 30) {
                return 30;
            } else if (bmi < 35) {
                return 40;
            } else if (bmi < 40) {
                return 41;
            } else if (bmi >= 40) {
                return 42;
            }
        }
        return -1;
    }

    public static void bmiMessage(int bmiCategory) {
        if (bmiCategory >= 0) {
            switch (bmiCategory) {
                case 10:
                    System.out.print("Very severely underweight");
                    break;
                case 11:
                    System.out.print("Severely underweight");
                    break;
                case 12:
                    System.out.print("Underweight");
                    break;
                case 20:
                    System.out.print("Normal");
                    break;
                case 30:
                    System.out.print("Overweight");
                    break;
                case 40:
                    System.out.print("Moderately obese");
                    break;
                case 41:
                    System.out.print("Severely obese");
                    break;
                case 42:
                    System.out.print("Very severely obese");
                    break;
            }
            return;
        }
        System.out.print("invalid");
    }

    public static void main(String[] args) {
        double weight, height, bmi;
        Scanner sc = new Scanner(System.in);
        System.out.printf("weight [kg]: ");
        weight = sc.nextDouble();
        System.out.printf("height [m]: ");
        height = sc.nextDouble();
        System.out.printf("m=%.2fkg h=%.2fm -> BMI=%.2f (", weight, height, bmi = bmiCalc(height, weight));
        bmiMessage(bmiCategory(bmi));
        System.out.printf(")\n");
    }
}
