import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Order class representing a customer's order
 * ENCAPSULATION: Encapsulates order details with private fields
 * Manages order items and bill calculation
 */
public class Order {
    private int orderId;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDateTime orderTime;
    private double taxRate; // e.g., 0.10 for 10% tax
    private static final double DEFAULT_TAX_RATE = 0.10;

    /**
     * Constructor for Order
     */
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.taxRate = DEFAULT_TAX_RATE;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /**
     * Adds a food item to the order
     */
    public void addItem(FoodItem foodItem, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        items.add(new OrderItem(foodItem, quantity));
    }

    /**
     * Removes an item from the order by index
     */
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    /**
     * Calculates subtotal (sum of all item prices before tax)
     */
    public double getSubtotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    /**
     * Calculates tax amount
     */
    public double getTaxAmount() {
        return getSubtotal() * taxRate;
    }

    /**
     * Calculates total bill including tax
     */
    public double getTotal() {
        return getSubtotal() + getTaxAmount();
    }

    /**
     * Checks if order is valid (has at least one item)
     */
    public boolean isValid() {
        return !items.isEmpty();
    }

    /**
     * Returns a complete order summary
     */
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("========================================\n");
        summary.append("             ORDER SUMMARY\n");
        summary.append("========================================\n");
        summary.append(String.format("Order ID: %d\n", orderId));
        summary.append(String.format("Order Time: %s\n",
                orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        summary.append("\nCustomer Details:\n");
        summary.append(String.format("Name: %s\n", customer.getName()));
        summary.append(String.format("Email: %s\n", customer.getEmail()));
        summary.append(String.format("Phone: %s\n", customer.getPhoneNumber()));
        summary.append(String.format("Address: %s\n", customer.getAddress()));

        summary.append("\n----------------------------------------\n");
        summary.append("Items Ordered:\n");
        summary.append("----------------------------------------\n");
        for (int i = 0; i < items.size(); i++) {
            summary.append(String.format("%d. %s\n", i + 1, items.get(i)));
        }

        summary.append("\n----------------------------------------\n");
        summary.append("Bill Details:\n");
        summary.append("----------------------------------------\n");
        summary.append(String.format("Subtotal: Rs.%.2f\n", getSubtotal()));
        summary.append(String.format("Tax (%.0f%%): Rs.%.2f\n", taxRate * 100, getTaxAmount()));
        summary.append(String.format("TOTAL: Rs.%.2f\n", getTotal()));
        summary.append("========================================\n");

        return summary.toString();
    }

    @Override
    public String toString() {
        return String.format("Order #%d - Customer: %s - Total: Rs.%.2f",
                orderId, customer.getName(), getTotal());
    }
}
