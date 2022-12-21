package org.store.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.store.customer.Basket;
import org.store.sale.Product;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

//    @BeforeEach
    public void constructBasket() {
        Basket basket = new Basket();
    }

    @ParameterizedTest
    void costProduct() {
//        Basket basket = new Basket();
//        assertTrue(Math.abs(basket.costProduct(new Product(2, "salt", 1.01), 3) - 3.03) < 0.000000001);
    }

    @Test
    void codtBasket() {

    }

}