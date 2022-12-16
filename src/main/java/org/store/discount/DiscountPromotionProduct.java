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
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return product.getPrice() * 0.9;
    }
}
