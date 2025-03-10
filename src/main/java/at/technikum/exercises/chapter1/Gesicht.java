package at.technikum.exercises.chapter1;

public class Gesicht {
    public static void main(String[] args) {
        System.out.println("0123456789012345");
        System.out.println("________________");
        System.out.println("\\              /");
        System.out.println(" \\  \"\"\"  \"\"\"  / ");
        System.out.println("  \\  o    o  /  ");
        System.out.println("   \\   --   /   ");
        System.out.println("    \\      /    ");
        System.out.println("     \\====/     ");
        System.out.println("      \\==/      ");
        System.out.println("       \\/       \n");

        System.out.println();

        System.out.println("0123456789012345");
        System.out.println("________________");
        System.out.printf("%s%15s\n", "\\", "/");
        System.out.printf("%2s%5s%5s%3s\n", "\\", "\"\"\"", "\"\"\"", "/");
        System.out.printf("%3s%3s%2s%3s%3s\n", "\\", "o", "", "o", "/");
        System.out.printf("%4s%5s%4s\n", "\\", "--", "/");
        System.out.printf("%5s%7s\n", "\\", "/");
        System.out.printf("%6s%s%s\n", "\\", "====", "/");
        System.out.printf("%7s%s%s\n", "\\", "==", "/");
        System.out.printf("%8s%s\n", "\\", "/");
    }
}
