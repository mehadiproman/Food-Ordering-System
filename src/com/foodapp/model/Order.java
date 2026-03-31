package com.foodapp.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Order class manages a collection of OrderItems for a Customer.
 * Handles tax calculations and order summary generation.
 */
public class Order {
    private final int orderId;
    private final Customer customer;
    private final List<OrderItem> items;
    private final LocalDateTime orderTime;
    private final double taxRate;
    private static final double DEFAULT_TAX_RATE = 0.10;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.taxRate = DEFAULT_TAX_RATE;
    }

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

    public void addItem(FoodItem foodItem, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0 or more");
        }
        items.add(new OrderItem(foodItem, quantity));
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public double getSubtotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    public double getTaxAmount() {
        return getSubtotal() * taxRate;
    }

    public double getTotal() {
        return getSubtotal() + getTaxAmount();
    }

    public boolean isValid() {
        return !items.isEmpty();
    }

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

        summary.append(String.format("Subtotal: %s\n", FoodItem.formatPrice(getSubtotal())));
        summary.append(String.format("Tax (%.0f%%): %s\n", taxRate * 100, FoodItem.formatPrice(getTaxAmount())));
        summary.append(String.format("TOTAL: %s\n", FoodItem.formatPrice(getTotal())));

        summary.append("========================================\n");

        return summary.toString();
    }

    @Override
    public String toString() {
        return String.format("Order #%d - Customer: %s - Total: %s",
                orderId, customer.getName(), FoodItem.formatPrice(getTotal()));
    }
}
