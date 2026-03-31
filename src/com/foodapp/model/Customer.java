package com.foodapp.model;

// Customer class representing a system user (Encapsulation)
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    // Constructor to initialize customer details
    public Customer(int customerId, String name, String email,
                    String phoneNumber, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Get customer ID
    public int getCustomerId() {
        return customerId;
    }

    // Get customer name
    public String getName() {
        return name;
    }

    // Get customer email
    public String getEmail() {
        return email;
    }

    // Get customer phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Get customer address
    public String getAddress() {
        return address;
    }

    // Validate customer data
    public boolean isValid() {
        return name != null && !name.isEmpty() &&
                email != null && !email.isEmpty() &&
                phoneNumber != null && !phoneNumber.isEmpty() &&
                address != null && !address.isEmpty();
    }

    // String representation of customer
    @Override
    public String toString() {
        return String.format("Customer ID: %d | Name: %s | Email: %s | Phone: %s | Address: %s",
                customerId, name, email, phoneNumber, address);
    }
}