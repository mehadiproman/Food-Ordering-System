/**
 * Pizza class extending FoodItem
 * INHERITANCE: Inherits from FoodItem
 * POLYMORPHISM: Overrides abstract methods with Pizza-specific implementation
 */
public class Pizza extends FoodItem {
    private String size; // e.g., "Small", "Medium", "Large"
    private int slices;

    /**
     * Constructor for Pizza
     */
    public Pizza(int itemId, String name, double price, String size, int slices) {
        super(itemId, name, price);
        this.size = size;
        this.slices = slices;
    }

    // Getters for Pizza-specific properties
    public String getSize() {
        return size;
    }

    public int getSlices() {
        return slices;
    }

    /**
     * POLYMORPHISM: Overrides abstract method from FoodItem
     * Provides Pizza-specific description
     */
    @Override
    public String getDescription() {
        return String.format("Pizza [%s] - %s (%d slices) (Rs.%.2f)",
                size, getName(), slices, getPrice());
    }

    /**
     * POLYMORPHISM: Overrides abstract validation method
     */
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && size != null && !size.isEmpty() &&
                slices > 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Size: " + size + " | Slices: " + slices;
    }
}
