package org.store.discount;

import org.store.sale.AbstractProduct;

public abstract class DiscountDecoration extends AbstractProduct {
    public abstract String getName();
    public abstract double getPrice();
    public abstract int getId();
    public abstract boolean isPromotion();

    public abstract double getCost(int quantity);
}