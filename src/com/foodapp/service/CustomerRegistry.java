import java.util.ArrayList;
import java.util.List;

/**
 * CustomerRegistry class managing customer registrations
 * ENCAPSULATION: Encapsulates customer storage and access
 */
public class CustomerRegistry {
    private List<Customer> customers;
    private int nextCustomerId;

    /**
     * Constructor initializing the registry
     */
    public CustomerRegistry() {
        this.customers = new ArrayList<>();
        this.nextCustomerId = 1001;
        initializeSampleCustomers();
    }

    /**
     * Initializes registry with sample customers
     */
    private void initializeSampleCustomers() {
        registerCustomer("Ahmed Khan", "ahmed@email.com", "03001234567", "Dhaka");
        registerCustomer("Fatima Ali", "fatima@email.com", "03009876543", "Chittagong");
        registerCustomer("Hassan Malik", "hassan@email.com", "03005555555", "Sylhet");
    }

    /**
     * Registers a new customer
     */
    public Customer registerCustomer(String name, String email,
                                     String phoneNumber, String address) {
        Customer customer = new Customer(nextCustomerId, name, email, phoneNumber, address);
        if (customer.isValid()) {
            customers.add(customer);
            nextCustomerId++;
            return customer;
        }
        return null;
    }

    /**
     * Finds customer by ID
     */
    public Customer findCustomerById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds customer by name (case-insensitive)
     */
    public Customer findCustomerByName(String name) {
        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns all registered customers
     */
    public List<Customer> getAllCustomers() {
        return customers;
    }

    /**
     * Checks if customer exists by ID
     */
    public boolean customerExists(int customerId) {
        return findCustomerById(customerId) != null;
    }

    /**
     * Displays all registered customers
     */
    public void displayAllCustomers() {
        System.out.println("\n========================================");
        System.out.println("      REGISTERED CUSTOMERS");
        System.out.println("========================================");
        if (customers.isEmpty()) {
            System.out.println("No customers registered yet.");
        } else {
            customers.forEach(customer ->
                    System.out.println(customer.getCustomerId() + ". " + customer.getName() +
                            " (" + customer.getEmail() + ")")
            );
        }
        System.out.println("========================================\n");
    }
}
