package com.ftc.collections;

import java.util.List;

/**
 * Main entry point for the FTC Inventory Management System.
 *
 * <p>HOW THIS FITS INTO FINDTHATCREAM: Simulates real admin operations —
 * adding products, managing sections, tracking brands, and processing
 * the new arrivals queue.</p>
 *
 * <p>OOP CONCEPTS DEMONSTRATED: All collection types working together —
 * List, Set, Map, Queue, and Generics in one running system.</p>
 *
 * <p>SPRING BOOT CONNECTION: This main method gets replaced by Spring Boot's
 * application context. Each method call here becomes a REST endpoint
 * called by the React frontend or admin panel.</p>
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class InventoryApp {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        // --- ADD PRODUCTS TO CATALOG ---
        manager.addProduct(new Product("Brambleberry Crisp", "Jeni's", 12.00, "New Arrivals", false));
        manager.addProduct(new Product("Pumpkin Pie", "Van Leeuwen", 11.00, "New Arrivals", true));
        manager.addProduct(new Product("Butter Pecan", "Jeni's", 12.00, "Viral", false));
        manager.addProduct(new Product("Matcha Milk", "Alec's", 13.00, "Healthy Picks", false));
        manager.addProduct(new Product("Cold Brew", "Häagen-Dazs", 10.00, "Viral", false));
        manager.addProduct(new Product("Peppermint Bark", "McConnell's", 14.00, "New Arrivals", true));

        // --- DISPLAY FULL CATALOG ---
        manager.displayCatalog();

        // --- DISPLAY UNIQUE BRANDS ---
        manager.displayBrands();

        // --- DISPLAY SECTIONS ---
        manager.displaySection("New Arrivals");
        manager.displaySection("Viral");
        manager.displaySection("Healthy Picks");

        // --- QUEUE NEW ARRIVALS ---
        System.out.println("\n--- Queueing new drops ---");
        manager.queueNewArrival(new Product("Strawberry Honey Balsamic", "Jeni's", 12.00, "New Arrivals", false));
        manager.queueNewArrival(new Product("Sweet Cream Peach", "Graeter's", 11.00, "New Arrivals", false));
        manager.displayQueue();

        // --- PROCESS QUEUE ---
        System.out.println("\n--- Processing next arrival ---");
        manager.processNextArrival();

        // --- REMOVE SEASONAL PRODUCTS ---
        System.out.println("\n--- Removing seasonal products ---");
        manager.removeSeasonalProducts();
        manager.displayCatalog();

        // --- GENERIC REPOSITORY ---
        System.out.println("\n--- Generic Repository Demo ---");
        GenericRepository<Product> productRepo = new GenericRepository<>("FTC Product Repository");
        productRepo.add(new Product("Brown Butter Almond", "Jeni's", 12.00, "Viral", false));
        productRepo.add(new Product("Oat Milk Chocolate", "Alec's", 13.00, "Healthy Picks", false));
        productRepo.displayAll();

        GenericRepository<String> brandRepo = new GenericRepository<>("FTC Brand Repository");
        brandRepo.add("Jeni's");
        brandRepo.add("Van Leeuwen");
        brandRepo.add("Graeter's");
        brandRepo.displayAll();

        // --- MISSING COLLECTION TYPES ---
        manager.displaySortedBrands();
        manager.displaySortedSections();
        manager.displayLinkedList();
        manager.displayPriorityQueue();
        manager.displayCollectionsUtility();

        // --- BOUNDED TYPE AND WILDCARD ---
        Product testProduct = new Product("Wildberry", "Jeni's", 12.00, "Viral", false);
        GenericRepository.displayProductInfo(testProduct);
        GenericRepository.displayRepositorySize(productRepo);
    }
}