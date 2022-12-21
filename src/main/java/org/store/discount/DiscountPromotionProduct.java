package org.store.discount;

import org.store.sale.AbstractProduct;
import org.store.sale.Product;
import org.store.sale.ProductFactory;

public class DiscountPromotionProduct extends DiscountDecoration{
    AbstractProduct product;
    static String description = "Promotion product more than 5 quantity is discount 10%";

    public DiscountPromotionProduct(AbstractProduct product) {
        this.product = product;
    }
    @Override
    public String getName() {
        return product.getName() + " -10% discount";
    }

    @Override
    public int getId() {
        return product.getId();
    }
    @Override
    public double getPrice() {
        return product.getPrice();
    }
    @Override
    public double getTax() {
        return product.getTax() - product.getPrice() * 0.1;
    }

    @Override
    public boolean isPromotion() {
        return product.isPromotion();
    }

    @Override
    public double getCost(int quantity) {
        return product.getPrice() * quantity;
    }

}
