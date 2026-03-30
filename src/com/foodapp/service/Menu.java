import java.util.ArrayList;
import java.util.List;

/**
 * Menu class managing all food items available in the system
 * ENCAPSULATION: Encapsulates the menu items with controlled access
 */
public class Menu {
    private List<FoodItem> items;

    /**
     * Constructor initializing the menu with predefined items
     */
    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    /**
     * Initializes menu with sample food items
     * Demonstrates POLYMORPHISM: Adding different types of items to same list
     */
    private void initializeMenu() {
        // Add Burgers
        items.add(new Burger(101, "Classic Burger", 250.0, "Beef"));
        items.add(new Burger(102, "Chicken Burger", 200.0, "Chicken"));
        items.add(new Burger(103, "Veggie Burger", 180.0, "Veggie"));

        // Add Pizzas
        items.add(new Pizza(201, "Margherita Pizza", 400.0, "Medium", 8));
        items.add(new Pizza(202, "Pepperoni Pizza", 500.0, "Large", 10));
        items.add(new Pizza(203, "Veggie Pizza", 380.0, "Medium", 8));

        // Add Drinks
        items.add(new Drink(301, "Cola", 80.0, 300, "Soft Drink"));
        items.add(new Drink(302, "Orange Juice", 120.0, 250, "Juice"));
        items.add(new Drink(303, "Bottled Water", 50.0, 500, "Water"));
    }

    /**
     * Returns all menu items
     */
    public List<FoodItem> getItems() {
        return items;
    }

    /**
     * Searches for a food item by ID
     */
    public FoodItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Displays the complete menu in a formatted way
     */
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("           AVAILABLE MENU ITEMS");
        System.out.println("========================================");

        // Display Burgers
        System.out.println("\n--- BURGERS ---");
        items.stream()
                .filter(item -> item instanceof Burger)
                .forEach(item -> System.out.println(item.getDescription()));

        // Display Pizzas
        System.out.println("\n--- PIZZAS ---");
        items.stream()
                .filter(item -> item instanceof Pizza)
                .forEach(item -> System.out.println(item.getDescription()));

        // Display Drinks
        System.out.println("\n--- DRINKS ---");
        items.stream()
                .filter(item -> item instanceof Drink)
                .forEach(item -> System.out.println(item.getDescription()));

        System.out.println("========================================\n");
    }

    /**
     * Returns count of items in menu
     */
    public int getItemCount() {
        return items.size();
    }
}
