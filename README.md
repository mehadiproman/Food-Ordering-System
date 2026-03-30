# Food Ordering System (Java - Console Application)

## Overview

This is a console-based Food Ordering System built using Java. The project demonstrates core Object-Oriented Programming (OOP) principles including Abstraction, Encapsulation, Inheritance, and Polymorphism.

Users can register as customers, browse food items, place orders, and view order summaries with calculated bills.

---

## Features

* Customer registration with validation
* Browse menu items (Burger, Pizza, Drink)
* Place orders with multiple items and quantities
* Automatic bill calculation (subtotal, tax, total)
* Order summary generation
* Order history tracking
* System statistics (total customers, orders, revenue)

---

## Technologies Used

* Java (JDK 11 or higher)
* Console-based input/output (Scanner)
* No external libraries

---

## Project Structure

```
FoodOrderingSystem/
└── src/
    └── com/foodapp/
        ├── Main.java
        ├── FoodOrderingSystem.java
        │
        ├── model/
        │   ├── FoodItem.java
        │   ├── Burger.java
        │   ├── Pizza.java
        │   ├── Drink.java
        │   ├── Customer.java
        │   ├── Order.java
        │   └── OrderItem.java
        │
        └── service/
            ├── Menu.java
            ├── CustomerRegistry.java
            └── OrderHistory.java
```

---

## OOP Principles Used

### Abstraction

* `FoodItem` is an abstract class
* Defines common structure for all food types

### Encapsulation

* All classes use private fields
* Access provided through getters
* Validation methods ensure data integrity

### Inheritance

* `Burger`, `Pizza`, `Drink` extend `FoodItem`
* Reuse common properties (id, name, price)

### Polymorphism

* `getDescription()` method overridden in subclasses
* `List<FoodItem>` stores different item types

---

## How to Run (CLI)

### Step 1: Navigate to project

```
cd FoodOrderingSystem/src
```

### Step 2: Compile

```
javac com/foodapp/model/*.java com/foodapp/service/*.java com/foodapp/*.java
```

### Step 3: Run

```
java com.foodapp.Main
```

---

## How to Run (IntelliJ)

1. Open project in IntelliJ
2. Ensure JDK is configured (Java 11 or higher)
3. Right-click `Main.java`
4. Click "Run Main"

---

## Sample Flow

1. Register a new customer
2. View menu items
3. Select items and quantities
4. Place order
5. View order summary with bill

---

## Key Classes

* `FoodItem` - Abstract base class for all food items
* `Burger`, `Pizza`, `Drink` - Specific food types
* `Customer` - Stores customer information
* `Order` - Manages items and bill calculation
* `OrderItem` - Represents item with quantity
* `Menu` - Displays and manages food items
* `CustomerRegistry` - Handles customer registration
* `OrderHistory` - Tracks all orders
* `FoodOrderingSystem` - Main controller
* `Main` - Entry point

---

## Requirements

* Java JDK 11 or higher
* Command line or IDE

---

## Notes

* This is a console-based application (no GUI)
* Data is stored in memory (no database)
* Menu and sample data are preloaded

---

## Author

Student Project for learning Java OOP and system design
