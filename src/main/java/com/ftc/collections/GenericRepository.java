package com.ftc.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic repository that can store and retrieve any FTC domain object.
 *
 * <p>HOW THIS FITS INTO FINDTHATCREAM: Instead of writing a separate
 * repository class for Products, Brands, and Retailers, one generic
 * class handles all of them with type safety.</p>
 *
 * <p>OOP CONCEPTS DEMONSTRATED: Generics — the type placeholder T means
 * this class works for any object type while remaining type safe at
 * compile time.</p>
 *
 * <p>SPRING BOOT CONNECTION: This is the manual version of what Spring
 * Data JPA does automatically with JpaRepository&lt;Product, Long&gt;
 * in Project 21. Same concept, Spring just generates the implementation
 * for you.</p>
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class GenericRepository<T> {

    private List<T> items = new ArrayList<>();
    private String repositoryName;

    public GenericRepository(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public void add(T item) {
        items.add(item);
        System.out.println("Added to " + repositoryName + ": " + item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public void remove(int index) {
        T removed = items.remove(index);
        System.out.println("Removed from " + repositoryName + ": " + removed);
    }

    public List<T> getAll() {
        return items;
    }

    public int size() {
        return items.size();
    }

    public void displayAll() {
        System.out.println("\n=== " + repositoryName + " ===");
        for (T item : items) {
            System.out.println(item);
        }
    }
    // BOUNDED TYPE — only accepts objects that extend Product
    public static <T extends Product> void displayProductInfo(T item) {
        System.out.println("Product: " + item.getName() + " | Brand: " + item.getBrand());
    }

    // WILDCARD — accepts repository of any type
    public static void displayRepositorySize(GenericRepository<?> repo) {
        System.out.println("Repository size: " + repo.size());
    }
}