package org.store.sale;

public abstract class AbstractProduct {

    private int id;
    private String name;
    private double price;
    private double tax;

    private boolean promotion = false;


    public boolean isPromotion() {
        return promotion;
    }

    public double getPrice(){
        return price;
    };

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double getTax();
}
