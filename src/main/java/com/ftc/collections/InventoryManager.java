package com.ftc.collections;

import java.util.*;

/**
 * Manages the FTC product inventory using Java Collections Framework.
 *
 * <p>HOW THIS FITS INTO FINDTHATCREAM: This class handles all admin
 * operations — adding products, removing seasonal flavors, organizing
 * products by homepage section, tracking unique brands, and managing
 * the new arrivals queue.</p>
 *
 * <p>OOP CONCEPTS DEMONSTRATED: List, Set, Map, and Queue — each
 * collection type chosen deliberately based on what the data needs.</p>
 *
 * <p>SPRING BOOT CONNECTION: These operations become @Service layer
 * methods in Spring Boot — addProduct(), removeProduct(), and
 * getProductsBySection() all become service methods called by
 * a @RestController endpoint.</p>
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class InventoryManager {

    // LIST — maintains order, allows duplicates, full catalog
    private List<Product> catalog = new ArrayList<>();

    // SET — unique brand names only, no duplicates
    private Set<String> brands = new HashSet<>();

    // MAP — section name maps to list of products in that section
    private Map<String, List<Product>> sections = new HashMap<>();

    // QUEUE — new drops waiting to go live on homepage
    private Queue<Product> newArrivalsQueue = new LinkedList<>();

    // --- LIST OPERATIONS ---

    public void addProduct(Product product) {
        catalog.add(product);
        brands.add(product.getBrand());
        sections.computeIfAbsent(product.getSection(),
                k -> new ArrayList<>()).add(product);
        System.out.println("Added: " + product.getName());
    }

    public void removeSeasonalProducts() {
        catalog.removeIf(p -> p.isSeasonal());
        System.out.println("All seasonal products removed from catalog.");
    }

    public void displayCatalog() {
        System.out.println("\n=== FTC FULL CATALOG ===");
        for (Product p : catalog) {
            System.out.println(p);
        }
    }

    // --- SET OPERATIONS ---

    public void displayBrands() {
        System.out.println("\n=== UNIQUE BRANDS ===");
        for (String brand : brands) {
            System.out.println(brand);
        }
    }

    // --- MAP OPERATIONS ---

    public void displaySection(String sectionName) {
        System.out.println("\n=== SECTION: " + sectionName + " ===");
        List<Product> sectionProducts = sections.get(sectionName);
        if (sectionProducts == null) {
            System.out.println("No products in this section.");
        } else {
            for (Product p : sectionProducts) {
                System.out.println(p);
            }
        }
    }

    // --- QUEUE OPERATIONS ---

    public void queueNewArrival(Product product) {
        newArrivalsQueue.offer(product);
        System.out.println("Queued for new arrivals: " + product.getName());
    }

    public void processNextArrival() {
        Product next = newArrivalsQueue.poll();
        if (next != null) {
            addProduct(next);
            System.out.println("Processed new arrival: " + next.getName());
        } else {
            System.out.println("No products in queue.");
        }
    }

    public void displayQueue() {
        System.out.println("\n=== NEW ARRIVALS QUEUE ===");
        for (Product p : newArrivalsQueue) {
            System.out.println(p.getName());
        }
    }
    // --- TREESET — sorted unique brands ---
    public void displaySortedBrands() {
        Set<String> sortedBrands = new TreeSet<>(brands);
        System.out.println("\n=== SORTED BRANDS (TreeSet) ===");
        for (String brand : sortedBrands) {
            System.out.println(brand);
        }
    }

    // --- TREEMAP — sections sorted by name ---
    public void displaySortedSections() {
        Map<String, List<Product>> sortedSections = new TreeMap<>(sections);
        System.out.println("\n=== SORTED SECTIONS (TreeMap) ===");
        for (String section : sortedSections.keySet()) {
            System.out.println(section + ": " + sortedSections.get(section).size() + " products");
        }
    }

    // --- LINKEDLIST as List — not just Queue ---
    public void displayLinkedList() {
        List<Product> linkedCatalog = new LinkedList<>(catalog);
        System.out.println("\n=== LINKEDLIST CATALOG ===");
        System.out.println("First product: " + linkedCatalog.get(0).getName());
        System.out.println("Last product: " + linkedCatalog.get(linkedCatalog.size() - 1).getName());
    }

    // --- PRIORITYQUEUE — products sorted by price ---
    public void displayPriorityQueue() {
        Queue<Product> priceQueue = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getPrice(), b.getPrice())
        );
        priceQueue.addAll(catalog);
        System.out.println("\n=== PRIORITY QUEUE (cheapest first) ===");
        while (!priceQueue.isEmpty()) {
            System.out.println(priceQueue.poll());
        }
    }

    // --- COLLECTIONS UTILITY METHODS ---
    public void displayCollectionsUtility() {
        List<String> brandList = new ArrayList<>(brands);
        System.out.println("\n=== COLLECTIONS UTILITY METHODS ===");
        System.out.println("Unsorted: " + brandList);
        Collections.sort(brandList);
        System.out.println("Sorted: " + brandList);
        Collections.reverse(brandList);
        System.out.println("Reversed: " + brandList);
        System.out.println("Max: " + Collections.max(brandList));
        System.out.println("Min: " + Collections.min(brandList));
    }
}