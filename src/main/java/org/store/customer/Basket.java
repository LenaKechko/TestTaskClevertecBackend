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
    private double total = 0.0;
    private double totalTax = 0.0;

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

    public void costBasket(){
        for (AbstractProduct product : basketList.keySet()) {
            int quantity = basketList.get(product);
            if (product.isPromotion() && quantity > 5){
                product = new DiscountPromotionProduct(product);
            }
            if (!product.isPromotion() && discountCard != null){
                product = new DiscountForCard(product);
            }
            double totalProduct = product.getCost(quantity);
            this.forBill += String.format("%4d %-22s %7.2f %7.2f\n",
                    quantity, product.getName(), product.getPrice(), totalProduct);
            if (product.getTax() != 0.0)  {
                double taxProduct = product.getTax() * quantity;
                totalTax += taxProduct;
                this.forBill += String.format("%43.2f\n", taxProduct);
            }
            total += totalProduct;
        }
    }

    public double getTotal(){
        return total;
    }

    public double getTotalTax(){
        return totalTax;
    }

    public double getFinalTotal() {
        return total + totalTax;
    }

    public DiscountCard getNumberDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }
}
