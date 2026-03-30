import java.util.ArrayList;
import java.util.List;

/**
 * OrderHistory class maintaining record of all orders
 * ENCAPSULATION: Encapsulates order storage and access
 */
public class OrderHistory {
    private List<Order> orders;
    private int nextOrderId;

    /**
     * Constructor initializing the order history
     */
    public OrderHistory() {
        this.orders = new ArrayList<>();
        this.nextOrderId = 5001;
    }

    /**
     * Adds a new order to history
     */
    public void addOrder(Order order) {
        if (order != null && order.isValid()) {
            orders.add(order);
            nextOrderId++;
        }
    }

    /**
     * Gets the next order ID to be used
     */
    public int getNextOrderId() {
        return nextOrderId;
    }

    /**
     * Finds order by ID
     */
    public Order findOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Gets all orders for a specific customer
     */
    public List<Order> getOrdersByCustomer(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().getCustomerId() == customer.getCustomerId())
                .toList();
    }

    /**
     * Gets all orders in history
     */
    public List<Order> getAllOrders() {
        return orders;
    }

    /**
     * Calculates total revenue from all orders
     */
    public double getTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
    }

    /**
     * Returns number of orders
     */
    public int getTotalOrderCount() {
        return orders.size();
    }

    /**
     * Displays all orders in the history
     */
    public void displayAllOrders() {
        System.out.println("\n========================================");
        System.out.println("           ALL ORDERS");
        System.out.println("========================================");
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            orders.forEach(order ->
                    System.out.println(order)
            );
            System.out.println("\nTotal Orders: " + orders.size());
            System.out.println("Total Revenue: Rs." + String.format("%.2f", getTotalRevenue()));
        }
        System.out.println("========================================\n");
    }

    /**
     * Displays orders for a specific customer
     */
    public void displayCustomerOrders(Customer customer) {
        List<Order> customerOrders = getOrdersByCustomer(customer);
        System.out.println("\n========================================");
        System.out.println("  ORDERS FOR: " + customer.getName());
        System.out.println("========================================");
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for this customer.");
        } else {
            customerOrders.forEach(order ->
                    System.out.println(order)
            );
            double totalSpent = customerOrders.stream()
                    .mapToDouble(Order::getTotal)
                    .sum();
            System.out.println("\nTotal Orders: " + customerOrders.size());
            System.out.println("Total Spent: Rs." + String.format("%.2f", totalSpent));
        }
        System.out.println("========================================\n");
    }
}
