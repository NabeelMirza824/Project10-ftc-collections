# Project 10 — Collections & Generics: FTC Inventory Management System

## Overview
Builds a product inventory system for FindThatCream using the Java Collections 
Framework and Generics. Covers List, Set, Map, Queue, and a custom generic 
repository class.

## Concepts Covered
- **List/ArrayList** — ordered catalog of all FTC products
- **Set/HashSet** — unique brand names, no duplicates
- **Map/HashMap** — products organized by homepage section
- **Queue/LinkedList** — new product drops waiting to go live
- **Generics** — one repository class that works for any FTC object type
- **Lambda expressions** — used with removeIf for clean collection operations

## Project Structure
ftc-collections/
└── src/main/java/com/ftc/collections/
├── Product.java              ← FTC product model
├── InventoryManager.java     ← List, Set, Map, Queue operations
├── GenericRepository.java    ← Generic class working with any type
└── InventoryApp.java         ← Main runner
## FTC Design Decisions
- ArrayList for full catalog — order matters, newest products show first
- HashSet for brands — curated list, no duplicate brand names allowed
- HashMap for sections — maps New Arrivals, Viral, Healthy Picks to their products
- Queue for new arrivals — first drop queued is first to go live on homepage

## Spring Boot Connection
| This Project | Spring Boot Equivalent |
|---|---|
| ArrayList catalog | @OneToMany product list on entity |
| HashMap sections | @Service method getProductsBySection() |
| GenericRepository | JpaRepository<Product, Long> |
| removeIf lambda | Spring Data JPA deleteBy methods |

## Author
Nabeel Mirza — EVAITCS Project 10
