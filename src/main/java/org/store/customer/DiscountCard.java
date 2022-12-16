package org.store.customer;

public class DiscountCard {
    private int number;

    public DiscountCard(int number) {
        if (number > 0)
            this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
