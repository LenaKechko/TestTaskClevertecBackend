package org.store.sale;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product extends AbstractProduct {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "promotion")
    private boolean promotion = false;

    private double tax = 0.0;

    public Product() {

    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, double price, boolean promotion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setTax() {
        this.tax = tax;
    }
    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public double getCost(int quantity) {
        return price * quantity;
    }

}
