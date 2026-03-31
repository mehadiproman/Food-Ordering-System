package com.foodapp.service;

import com.foodapp.model.Customer;
import com.foodapp.model.FoodItem;
import com.foodapp.model.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderHistory manages all orders (Encapsulation)
 * Provides tracking and reporting of sales data.
 */
public class OrderHistory {
    private final List<Order> orders;
    private int nextOrderId;

    // Constructor initializes order history
    public OrderHistory() {
        this.orders = new ArrayList<>();
        this.nextOrderId = 5001;
    }

    // Add valid order to history
    public void addOrder(Order order) {
        if (order != null && order.isValid()) {
            orders.add(order);
            nextOrderId++;
        }
    }

    // Get next order ID
    public int getNextOrderId() {
        return nextOrderId;
    }

    // Find order by ID
    public Order findOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    // Get orders by specific customer
    public List<Order> getOrdersByCustomer(Customer customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().getCustomerId() == customer.getCustomerId())
                .toList();
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orders;
    }

    // Calculate total revenue
    public double getTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
    }

    // Get total number of orders
    public int getTotalOrderCount() {
        return orders.size();
    }

    // Display all orders summary
    public void displayAllOrders() {
        System.out.println("\n========================================");
        System.out.println("           ALL ORDERS");
        System.out.println("========================================");
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            orders.forEach(System.out::println);
            System.out.println("\nTotal Orders: " + orders.size());
            System.out.println("Total Revenue: " + FoodItem.formatPrice(getTotalRevenue()));
        }
        System.out.println("========================================\n");
    }

    // Display orders for a specific customer
    public void displayCustomerOrders(Customer customer) {
        List<Order> customerOrders = getOrdersByCustomer(customer);
        System.out.println("\n========================================");
        System.out.println("  ORDERS FOR: " + customer.getName());
        System.out.println("========================================");
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for this customer.");
        } else {
            customerOrders.forEach(System.out::println);
            double totalSpent = customerOrders.stream()
                    .mapToDouble(Order::getTotal)
                    .sum();
            System.out.println("\nTotal Orders: " + customerOrders.size());
            System.out.println("Total Spent: " + FoodItem.formatPrice(totalSpent));
        }
        System.out.println("========================================\n");
    }
}
