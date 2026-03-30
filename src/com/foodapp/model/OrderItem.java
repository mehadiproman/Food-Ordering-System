/**
 * OrderItem class representing a food item with quantity in an order
 * ENCAPSULATION: Encapsulates food item and quantity information
 */
public class OrderItem {
    private FoodItem foodItem;
    private int quantity;

    /**
     * Constructor for OrderItem
     */
    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Getters
    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates subtotal for this order item
     * Subtotal = Price * Quantity
     */
    public double getSubtotal() {
        return foodItem.getPrice() * quantity;
    }

    /**
     * Returns a detailed string representation of the order item
     */
    @Override
    public String toString() {
        return String.format("%s x %d = Rs.%.2f",
                foodItem.getName(), quantity, getSubtotal());
    }
}
