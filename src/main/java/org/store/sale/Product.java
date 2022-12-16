package org.store.sale;

public class Product extends AbstractProduct {
    private int id;
    private String name;
    private double price;

    private double tax = 0.0;
    private boolean promotion = false;

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

    public boolean isPromotion() {
        return promotion;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }
}
