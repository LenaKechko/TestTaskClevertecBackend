package org.store.discount;

import org.store.sale.AbstractProduct;
import org.store.sale.ProductFactory;

public class DiscountForCard extends DiscountDecoration {
    AbstractProduct product;
    static String description = "Discount card 5%";

    public DiscountForCard(AbstractProduct product) {
        this.product= product;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /* if you have discount card, discount is 5%*/
    public double getPrice() {
        return product.getPrice() * 0.95;
    }


}
