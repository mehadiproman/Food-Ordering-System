/**
 * Customer class representing a customer in the system
 * ENCAPSULATION: Encapsulates customer information with private fields
 * and controlled access through getters
 */
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    /**
     * Constructor for Customer
     */
    public Customer(int customerId, String name, String email,
                    String phoneNumber, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters (Encapsulation - controlled access to private fields)
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Validates customer information
     */
    public boolean isValid() {
        return name != null && !name.isEmpty() &&
                email != null && !email.isEmpty() &&
                phoneNumber != null && !phoneNumber.isEmpty() &&
                address != null && !address.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d | Name: %s | Email: %s | Phone: %s | Address: %s",
                customerId, name, email, phoneNumber, address);
    }
}
