package com.foodapp.model;

/**
 * Drink class extends FoodItem (Inheritance, Polymorphism)
 * Represents a drink menu item.
 */
public class Drink extends FoodItem {
    private final int volumeMl; // Volume in milliliters
    private final String type;  // Drink type (e.g., Soft Drink, Juice, Water)

    // Constructor to initialize Drink object
    public Drink(int itemId, String name, double price, int volumeMl, String type) {
        super(itemId, name, price);
        this.volumeMl = volumeMl;
        this.type = type;
    }

    // Get drink volume
    public int getVolumeMl() {
        return volumeMl;
    }

    // Get drink type
    public String getType() {
        return type;
    }

    // Provides formatted description (method override)
    @Override
    public String getDescription() {
        return String.format("[%d] Drink [%s] - %s (%dml) (%s)",
                getItemId(), type, getName(), volumeMl, formatPrice(getPrice()));
    }

    // Validates drink data (method override)
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && volumeMl > 0 &&
                type != null && !type.isEmpty();
    }

    // Custom string representation
    @Override
    public String toString() {
        return super.toString() + " | Volume: " + volumeMl + "ml | Type: " + type;
    }
}
