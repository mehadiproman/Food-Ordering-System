package com.foodapp.service;

import com.foodapp.model.*;
import java.util.ArrayList;
import java.util.List;

// Menu class manages all food items (Encapsulation, Polymorphism)
public class Menu {
    private List<FoodItem> items;

    // Constructor initializes menu with predefined items
    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    // Adds sample food items to menu (demonstrates polymorphism)
    private void initializeMenu() {
        // Add Burgers
        items.add(new Burger(101, "Classic Burger", 250.0, "Beef"));
        items.add(new Burger(102, "Chicken Burger", 200.0, "Chicken"));
        items.add(new Burger(103, "Veggie Burger", 180.0, "Veggie"));

        // Add Pizzas
        items.add(new Pizza(201, "Margherita Pizza", 400.0, "Medium", 8));
        items.add(new Pizza(202, "Pepperoni Pizza", 500.0, "Large", 10));
        items.add(new Pizza(203, "Veggie Pizza", 380.0, "Medium", 8));

        // Add Drinks
        items.add(new Drink(301, "Cola", 80.0, 300, "Soft Drink"));
        items.add(new Drink(302, "Orange Juice", 120.0, 250, "Juice"));
        items.add(new Drink(303, "Bottled Water", 50.0, 500, "Water"));
    }

    // Get all menu items
    public List<FoodItem> getItems() {
        return items;
    }

    // Find item by ID
    public FoodItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElse(null);
    }

    // Display menu grouped by category
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("           AVAILABLE MENU ITEMS");
        System.out.println("========================================");

        // Display Burgers
        System.out.println("\n--- BURGERS ---");
        items.stream()
                .filter(item -> item instanceof Burger)
                .forEach(item -> System.out.println(item.getDescription()));

        // Display Pizzas
        System.out.println("\n--- PIZZAS ---");
        items.stream()
                .filter(item -> item instanceof Pizza)
                .forEach(item -> System.out.println(item.getDescription()));

        // Display Drinks
        System.out.println("\n--- DRINKS ---");
        items.stream()
                .filter(item -> item instanceof Drink)
                .forEach(item -> System.out.println(item.getDescription()));

        System.out.println("========================================\n");
    }

    // Get total number of menu items
    public int getItemCount() {
        return items.size();
    }
}