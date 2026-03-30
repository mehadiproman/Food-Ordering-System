/**
 * Abstract base class for all food items
 * ABSTRACTION: Defines common structure for all food types
 * ENCAPSULATION: Encapsulates food properties with private fields and public getters
 */
public abstract class FoodItem {
    private int itemId;
    private String name;
    private double price;

    /**
     * Constructor for FoodItem
     */
    public FoodItem(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    // Getters (Encapsulation - controlled access to private fields)
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Abstract method to get detailed description
     * ABSTRACTION: Each subclass must implement this
     */
    public abstract String getDescription();

    /**
     * Abstract method to validate item
     * ABSTRACTION: Each subclass defines its own validation
     */
    public abstract boolean isValid();

    /**
     * Returns a string representation of the food item
     */
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Price: Rs.%.2f", itemId, name, price);
    }
}
