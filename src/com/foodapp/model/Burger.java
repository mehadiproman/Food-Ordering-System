package com.foodapp.model;

/**
 * Burger class extends FoodItem (Inheritance, Polymorphism)
 * Represents a burger menu item.
 */
public class Burger extends FoodItem {
    private final String type; // Burger type (e.g., Veggie, Chicken, Beef)

    // Constructor to initialize Burger object
    public Burger(int itemId, String name, double price, String type) {
        super(itemId, name, price);
        this.type = type;
    }

    // Returns burger type
    public String getType() {
        return type;
    }

    // Provides formatted description (method override)
    @Override
    public String getDescription() {
        return String.format("[%d] Burger [%s] - %s (%s)",
                getItemId(), type, getName(), formatPrice(getPrice()));
    }

    // Validates burger data (method override)
    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty() &&
                getPrice() > 0 && type != null && !type.isEmpty();
    }

    // Custom string representation
    @Override
    public String toString() {
        return super.toString() + " | Type: " + type;
    }
}
