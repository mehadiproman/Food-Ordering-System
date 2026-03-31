package com.foodapp.model;

/**
 * OrderItem class represents a food item with quantity (Encapsulation)
 * Handles individual item calculations within an order.
 */
public class OrderItem {
    private final FoodItem foodItem;
    private final int quantity;

    // Constructor to initialize order item
    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Get food item
    public FoodItem getFoodItem() {
        return foodItem;
    }

    // Get quantity
    public int getQuantity() {
        return quantity;
    }

    // Calculate subtotal (price × quantity)
    public double getSubtotal() {
        return foodItem.getPrice() * quantity;
    }

    // String representation of order item
    @Override
    public String toString() {
        return String.format("%s x %d = %s",
                foodItem.getName(), quantity, FoodItem.formatPrice(getSubtotal()));
    }
}
