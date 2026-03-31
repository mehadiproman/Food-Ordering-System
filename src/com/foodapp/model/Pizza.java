package com.foodapp.model;

/**
 * Pizza class extends FoodItem (Inheritance, Polymorphism)
 * Represents a pizza menu item.
 */
public class Pizza extends FoodItem {
    private final String size; // Pizza size (e.g., Small, Medium, Large)
    private final int slices;

    // Constructor to initialize Pizza object
    public Pizza(int itemId, String name, double price, String size, int slices) {
        super(itemId, name, price);
        this.size = size;
        this.slices = slices;
    }

    // Get pizza size
    public String getSize() {
        return size;
    }

    // Get number of slices
    public int getSlices() {
        return slices;
    }

    // Provides formatted description (method override)
    @Override
    public String getDescription() {
        return String.format("[%d] Pizza [%s] - %s (%d slices) (%s)",
                getItemId(), size, getName(), slices, formatPrice(getPrice()));
    }

    // Validates pizza data (method override)
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && size != null && !size.isEmpty() &&
                slices > 0;
    }

    // Custom string representation
    @Override
    public String toString() {
        return super.toString() + " | Size: " + size + " | Slices: " + slices;
    }
}
