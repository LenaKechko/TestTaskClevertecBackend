package org.store.discount;

import org.store.sale.AbstractProduct;

public class DiscountForCard extends DiscountDecoration {
    AbstractProduct product;
    static String description = "Discount card 5%";

    public DiscountForCard(AbstractProduct product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName() + " -5% discount";
    }

    @Override
    public int getId() {
        return product.getId();
    }

    @Override
    public boolean isPromotion() {
        return product.isPromotion();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    /* if you have discount card, discount is 5%*/
    @Override
    public double getTax() {
        return product.getTax() - product.getPrice() * 0.05;
    }

    @Override
    public double getCost(int quantity) {
        return product.getPrice() * quantity;
    }



}
