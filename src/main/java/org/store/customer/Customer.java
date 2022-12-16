package org.store.customer;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<Integer, Integer> shoppingList = new HashMap<>();
    private Builder builder;
    private int numberDiscountCard = -1;

    public Customer() {
        builder = new BasketBuilder();
    }

    public Customer(int number) {
        builder = new BasketBuilder();
        if (number > 0)
            this.numberDiscountCard = number;
    }

    public void addProduct(int id, int quantity) {
        this.shoppingList.put(id, quantity);
    }

    public void addProduct(Map<Integer, Integer> list) {
        this.shoppingList.putAll(list);
    }

    public Map<Integer, Integer> getShoppingList() {
        return shoppingList;
    }

    public int getNumberDiscountCard() {
        return numberDiscountCard;
    }

    public Basket counstructBasket() {
        builder.addProductIntoBasket(shoppingList);
        builder.addDiscountCard(numberDiscountCard);
        return builder.getBasket();
    }


}
