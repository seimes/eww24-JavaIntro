package at.technikum.exercises.chapter4;

import java.util.Scanner;

public class Classifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter price: ");
        int price = sc.nextInt();
        System.out.print("enter quality: ");
        int quality = sc.nextInt();

        String classification = "";

        boolean highPrice = price >= 50;
        boolean highQuality = quality >= 50;

        if (!highPrice && !highQuality) {
            classification = "junk";
        } else if (highPrice && !highQuality) {
            classification = "rip off";
        } else if (highQuality && !highPrice) {
            classification = "bargain";
        }
        else {
            classification = "luxury";
        }

        if (highPrice) {
            System.out.println("high price");
        }
        else {
            System.out.println("low price");
        }

        if (highQuality) {
            System.out.println("high quality");
        }
        else {
            System.out.println("low quality");
        }

        System.out.println(classification);
    }
}
