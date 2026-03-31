package com.foodapp;

import com.foodapp.model.*;
import com.foodapp.service.*;
import java.util.Scanner;

/**
 * Main application class for the Food Ordering System.
 * Orchestrates the interaction between menu, customer registry, and order history.
 */
public class FoodOrderingSystem {
    private final Menu menu;
    private final CustomerRegistry customerRegistry;
    private final OrderHistory orderHistory;
    private final Scanner scanner;
    private boolean isRunning;

    public FoodOrderingSystem(Scanner scanner) {
        this.menu = new Menu();
        this.customerRegistry = new CustomerRegistry();
        this.orderHistory = new OrderHistory();
        this.scanner = scanner;
        this.isRunning = true;
    }

    public void run() {
        displayWelcomeMessage();

        while (isRunning) {
            displayMainMenu();
            int choice = getUserInput("Enter your choice: ");

            switch (choice) {
                case 1 -> handleCustomerRegistration();
                case 2 -> handlePlaceOrder();
                case 3 -> handleViewOrderHistory();
                case 4 -> handleViewMenu();
                case 5 -> handleViewAllCustomers();
                case 6 -> handleViewSystemStatistics();
                case 7 -> handleExit();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayWelcomeMessage() {
        System.out.println("\n========================================");
        System.out.println("  WELCOME TO FOOD ORDERING SYSTEM");
        System.out.println("========================================\n");
    }

    private void displayMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Register as New Customer");
        System.out.println("2. Place Order");
        System.out.println("3. View Order History");
        System.out.println("4. View Menu");
        System.out.println("5. View All Customers");
        System.out.println("6. View System Statistics");
        System.out.println("7. Exit");
    }

    private void handleCustomerRegistration() {
        System.out.println("\n========================================");
        System.out.println("    CUSTOMER REGISTRATION");
        System.out.println("========================================");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Customer customer = customerRegistry.registerCustomer(name, email, phoneNumber, address);

        if (customer != null && customer.isValid()) {
            System.out.println("\n✓ Customer registered successfully!");
            System.out.println("Your Customer ID: " + customer.getCustomerId());
        } else {
            System.out.println("\n✗ Registration failed. Please ensure all fields are filled.");
        }
    }

    private void handlePlaceOrder() {
        System.out.println("\n========================================");
        System.out.println("           PLACE ORDER");
        System.out.println("========================================");

        Customer customer = getCustomerInput();
        if (customer == null) {
            return;
        }

        Order order = new Order(orderHistory.getNextOrderId(), customer);

        boolean addingItems = true;
        while (addingItems) {
            menu.displayMenu();

            int itemId = getUserInput("Enter item ID to add to order (0 to finish): ");

            if (itemId == 0) {
                addingItems = false;
            } else {
                FoodItem item = menu.findItemById(itemId);
                if (item != null) {
                    int quantity = getUserInput("Enter quantity: ");
                    if (quantity > 0) {
                        order.addItem(item, quantity);
                        System.out.println("✓ " + item.getName() + " x" + quantity +
                                " added to order!");
                    } else {
                        System.out.println("✗ Quantity must be greater than 0.");
                    }
                } else {
                    System.out.println("✗ Item not found. Please check the item ID.");
                }
            }
        }

        if (order.isValid()) {
            orderHistory.addOrder(order);
            System.out.println(order.getOrderSummary());
            System.out.println("✓ Order placed successfully!");
        } else {
            System.out.println("\n✗ Order is empty. No items were added.");
        }
    }

    private void handleViewOrderHistory() {
        System.out.println("\n========================================");
        System.out.println("           VIEW ORDER HISTORY");
        System.out.println("========================================");
        System.out.println("1. View all orders");
        System.out.println("2. View orders for a specific customer");

        int choice = getUserInput("Enter your choice: ");

        if (choice == 1) {
            orderHistory.displayAllOrders();
        } else if (choice == 2) {
            Customer customer = getCustomerInput();
            if (customer != null) {
                orderHistory.displayCustomerOrders(customer);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void handleViewMenu() {
        menu.displayMenu();
    }

    private void handleViewAllCustomers() {
        customerRegistry.displayAllCustomers();
    }

    private void handleViewSystemStatistics() {
        System.out.println("\n========================================");
        System.out.println("       SYSTEM STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Menu Items: " + menu.getItemCount());
        System.out.println("Total Registered Customers: " +
                customerRegistry.getAllCustomers().size());
        System.out.println("Total Orders: " + orderHistory.getTotalOrderCount());
        System.out.println("Total Revenue: " +
                FoodItem.formatPrice(orderHistory.getTotalRevenue()));
        System.out.println("========================================\n");
    }

    private void handleExit() {
        System.out.println("\n========================================");
        System.out.println("   Thank you for using our system!");
        System.out.println("========================================\n");
        isRunning = false;
    }

    private Customer getCustomerInput() {
        System.out.println("\nSelect customer:");
        System.out.println("1. Enter by Customer ID");
        System.out.println("2. Enter by Name");
        System.out.println("3. Cancel");

        int choice = getUserInput("Enter your choice: ");

        Customer customer = null;

        switch (choice) {
            case 1 -> {
                int customerId = getUserInput("Enter customer ID: ");
                customer = customerRegistry.findCustomerById(customerId);
                if (customer == null) {
                    System.out.println("✗ Customer not found.");
                }
            }
            case 2 -> {
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                customer = customerRegistry.findCustomerByName(name);
                if (customer == null) {
                    System.out.println("✗ Customer not found.");
                }
            }
            case 3 -> System.out.println("Cancelled.");
            default -> System.out.println("Invalid choice.");
        }

        return customer;
    }

    private int getUserInput(String prompt) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserInput(prompt);
        }
    }
}
