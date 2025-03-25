package at.technikum.w3resourceOOP.exercise4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);

        System.out.println("Circle has radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.getCircumference());
        System.out.println();

        circle.setRadius(5.5);
        System.out.println("Circle has radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}
