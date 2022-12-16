package org.store.customer;

import org.store.discount.DiscountForCard;
import org.store.discount.DiscountPromotionProduct;
import org.store.sale.AbstractProduct;
import org.store.sale.Product;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Product, Integer> basketList = new HashMap<>();
    private String forBill = "";

    private DiscountCard discountCard = null;

    public void putProduct(Product product, int quantity){
        basketList.put(product, quantity);
    }

    public Map<Product, Integer> getBasketList() {
        return basketList;
    }

    public String printBill() {
        return forBill;
    }

    public double costBasket(){
        double total = 0.0;
        for (AbstractProduct product : basketList.keySet()) {
            int quantity = basketList.get(product);
            if (product.isPromotion() && basketList.get(product) > 5){
                product = new DiscountPromotionProduct(product);
            }
            if (!product.isPromotion() && discountCard != null){
                product = new DiscountForCard(product);
            }
            double totalProduct = product.getPrice() * quantity;
            this.forBill += String.format("%4d %10s %7.2f %7.2f\n",
                    quantity, product.getName(), product.getPrice(), totalProduct);
            total += totalProduct;
        }
        return total;
    }

    public DiscountCard getNumberDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }
}
