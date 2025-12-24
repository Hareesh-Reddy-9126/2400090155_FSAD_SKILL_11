package com.example;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Demonstrates CRUD for Product using Hibernate.
 */
public class App {

    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    public static void main(String[] args) {
        try {
            List<Long> productIds = createProducts();

            if (!productIds.isEmpty()) {
                Long firstId = productIds.get(0);
                Long secondId = productIds.size() > 1 ? productIds.get(1) : firstId;
                Long thirdId = productIds.size() > 2 ? productIds.get(2) : firstId;

                readProduct(firstId);
                updateProduct(secondId, new BigDecimal("1199.99"), 42);
                deleteProduct(thirdId);
            }
        } finally {
            sessionFactory.close();
        }
    }

    private static List<Long> createProducts() {
        Product laptop = new Product("Laptop", "15 inch business laptop", new BigDecimal("1299.99"), 10);
        Product mouse = new Product("Mouse", "Wireless ergonomic mouse", new BigDecimal("39.99"), 75);
        Product chair = new Product("Chair", "Ergonomic office chair", new BigDecimal("249.00"), 15);

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(laptop);
            session.persist(mouse);
            session.persist(chair);
            session.flush(); // ensures IDs are generated
            tx.commit();
        }

        System.out.println("Inserted products: " + laptop + " | " + mouse + " | " + chair);
        return List.of(laptop.getId(), mouse.getId(), chair.getId());
    }

    private static void readProduct(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Product found = session.get(Product.class, id);
            if (found != null) {
                System.out.println("Retrieved: " + found);
            } else {
                System.out.println("Product with id=" + id + " not found");
            }
        }
    }

    private static void updateProduct(Long id, BigDecimal newPrice, int newQuantity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Product found = session.get(Product.class, id);
            if (found != null) {
                found.setPrice(newPrice);
                found.setQuantity(newQuantity);
                session.merge(found);
                tx.commit();
                System.out.println("Updated: " + found);
            } else {
                System.out.println("Product with id=" + id + " not found for update");
                tx.rollback();
            }
        }
    }

    private static void deleteProduct(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Product found = session.get(Product.class, id);
            if (found != null) {
                session.remove(found);
                tx.commit();
                System.out.println("Deleted product id=" + id);
            } else {
                System.out.println("Product with id=" + id + " not found for delete");
                tx.rollback();
            }
        }
    }
}
