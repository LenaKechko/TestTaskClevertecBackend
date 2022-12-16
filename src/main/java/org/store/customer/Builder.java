package org.store.customer;

import java.util.Map;

public interface Builder {
    public void addProductIntoBasket(Map<Integer, Integer> shoppingList);
    public Basket getBasket();

    public void addDiscountCard(int numberDiscontCard);
}
