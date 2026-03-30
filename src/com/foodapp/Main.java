import java.util.Scanner;

/**
 * Main entry point for the Food Ordering System
 * Demonstrates a complete console-based ordering application
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodOrderingSystem system = new FoodOrderingSystem(scanner);

        system.run();

        scanner.close();
    }
}
