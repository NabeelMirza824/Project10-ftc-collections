package com.ftc.collections;

/**
 * Represents a single FTC product in the inventory system.
 *
 * <p>HOW THIS FITS INTO FINDTHATCREAM: Every product in the FTC catalog
 * has a name, brand, price, and section. This class is the foundation
 * of the inventory management system.</p>
 *
 * <p>OOP CONCEPTS DEMONSTRATED: Encapsulation — all fields private,
 * accessed through getters and setters.</p>
 *
 * <p>SPRING BOOT CONNECTION: This becomes a @Entity class mapped to
 * a MySQL product table via Hibernate in Project 21.</p>
 *
 * @author Nabeel Mirza
 * @version 1.0.0
 */
public class Product {

    private String name;
    private String brand;
    private double price;
    private String section;
    private boolean isSeasonal;

    public Product(String name, String brand, double price,
                   String section, boolean isSeasonal) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.section = section;
        this.isSeasonal = isSeasonal;
    }

    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public String getSection() { return section; }
    public boolean isSeasonal() { return isSeasonal; }

    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(double price) { this.price = price; }
    public void setSection(String section) { this.section = section; }
    public void setSeasonal(boolean seasonal) { isSeasonal = seasonal; }

    @Override
    public String toString() {
        return brand + " — " + name + " | $" + price +
                " | Section: " + section +
                " | Seasonal: " + isSeasonal;
    }
}