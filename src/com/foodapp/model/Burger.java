/**
 * Burger class extending FoodItem
 * INHERITANCE: Inherits from FoodItem
 * POLYMORPHISM: Overrides abstract methods with Burger-specific implementation
 */
public class Burger extends FoodItem {
    private String type; // e.g., "Veggie", "Chicken", "Beef"

    /**
     * Constructor for Burger
     */
    public Burger(int itemId, String name, double price, String type) {
        super(itemId, name, price);
        this.type = type;
    }

    // Getter for Burger-specific property
    public String getType() {
        return type;
    }

    /**
     * POLYMORPHISM: Overrides abstract method from FoodItem
     * Provides Burger-specific description
     */
    @Override
    public String getDescription() {
        return String.format("Burger [%s] - %s (Rs.%.2f)",
                type, getName(), getPrice());
    }

    /**
     * POLYMORPHISM: Overrides abstract validation method
     */
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && type != null && !type.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: " + type;
    }
}
