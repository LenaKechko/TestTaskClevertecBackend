package org.store.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.store.sale.Product;
import org.store.sale.ProductFactory;
import org.store.services.ProductService;

import java.util.List;
import java.util.Map;

public class BasketBuilder implements Builder {
    @Autowired
    private ProductService productService;
    private Basket basket = new Basket();


    @Override
    public void addProductIntoBasket(Map<Integer, Integer> shoppingList) {
        for (int id : shoppingList.keySet()) {
            Product product = ProductFactory.getProduct(id);
            if (product != null) {
                basket.putProduct(product, shoppingList.get(id));
            }
        }
    }

    @Override
    public Basket getBasket() {
        return this.basket;
    }

    @Override
    public void addDiscountCard(int numberDiscountCard) {
        if (numberDiscountCard > -1) {
            List<DiscountCard> discountCardList = DiscountCardFactory.getCardList();
            DiscountCard discountCard = discountCardList.stream()
                    .filter(value -> value.getNumber() == numberDiscountCard)
                    .findFirst()
                    .get();
            if (discountCard != null)
                basket.setDiscountCard(discountCard);
        }
    }
}
