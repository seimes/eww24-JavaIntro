package at.technikum.exercises.chapter1;

public class TheLifeOfPi {
    public static void main(String[] args) {
        double pi = 3.14159265359;

        System.out.printf("Pi = %f!\n", pi);
        System.out.printf("Pi = %12f!\n", pi);
        System.out.printf("Pi = %12.2f!\n", pi);
        System.out.printf("Pi = %10.0f!\n", pi);
        System.out.printf("Pi = %13.11f!\n", pi);
        System.out.printf("Pi = %015f!\n", pi);
        System.out.printf("Pi = %+015.2f!\n", pi);
    }
}
