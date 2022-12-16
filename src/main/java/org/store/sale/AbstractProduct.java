package org.store.sale;

public abstract class AbstractProduct {

    private int id;
    private String name;
    private double price;

    private boolean promotion = false;


    public boolean isPromotion() {
        return promotion;
    }

    public abstract double getPrice();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
