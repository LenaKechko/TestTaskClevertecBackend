package org.store.customer;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_card")
public class DiscountCard {
    @Id
    @Column(name = "number_card")
    private int number;

    public DiscountCard() {

    }

    public DiscountCard(int number) {
        if (number > 0)
            this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
