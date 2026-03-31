package com.foodapp.model;

/**
 * Abstract base class for all food items (Abstraction, Encapsulation)
 * Centralizes currency configuration and formatting.
 */
public abstract class FoodItem {
    public static final String CURRENCY = "BDT";

    private final int itemId;
    private final String name;
    private final double price;

    // Constructor to initialize common food properties
    public FoodItem(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    // Static helper for consistent currency formatting across the project
    public static String formatPrice(double amount) {
        return String.format("%s %.2f", CURRENCY, amount);
    }

    // Get item ID
    public int getItemId() {
        return itemId;
    }

    // Get item name
    public String getName() {
        return name;
    }

    // Get item price
    public double getPrice() {
        return price;
    }

    // Abstract method for item description (must be implemented by subclasses)
    public abstract String getDescription();

    // Abstract method for validation (must be implemented by subclasses)
    public abstract boolean isValid();

    // String representation of food item
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Price: %s", 
                itemId, name, formatPrice(price));
    }
}
