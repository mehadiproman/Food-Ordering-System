package com.foodapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodOrderingSystem system = new FoodOrderingSystem(scanner);

        system.run();

        scanner.close();
    }
}