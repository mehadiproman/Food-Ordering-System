/**
 * Drink class extending FoodItem
 * INHERITANCE: Inherits from FoodItem
 * POLYMORPHISM: Overrides abstract methods with Drink-specific implementation
 */
public class Drink extends FoodItem {
    private int volumeMl; // Volume in milliliters
    private String type;  // e.g., "Soft Drink", "Juice", "Water"

    /**
     * Constructor for Drink
     */
    public Drink(int itemId, String name, double price, int volumeMl, String type) {
        super(itemId, name, price);
        this.volumeMl = volumeMl;
        this.type = type;
    }

    // Getters for Drink-specific properties
    public int getVolumeMl() {
        return volumeMl;
    }

    public String getType() {
        return type;
    }

    /**
     * POLYMORPHISM: Overrides abstract method from FoodItem
     * Provides Drink-specific description
     */
    @Override
    public String getDescription() {
        return String.format("Drink [%s] - %s (%dml) (Rs.%.2f)",
                type, getName(), volumeMl, getPrice());
    }

    /**
     * POLYMORPHISM: Overrides abstract validation method
     */
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && volumeMl > 0 &&
                type != null && !type.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + " | Volume: " + volumeMl + "ml | Type: " + type;
    }
}
