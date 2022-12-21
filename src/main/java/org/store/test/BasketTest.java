package org.store.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.store.customer.Basket;
import org.store.customer.BasketBuilder;
import org.store.customer.Customer;
import org.store.customer.DiscountCard;
import org.store.discount.DiscountForCard;
import org.store.discount.DiscountPromotionProduct;
import org.store.sale.AbstractProduct;
import org.store.sale.Product;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1.01, 3, 3.03",
            "2.51, 7, 17.57",
            "1.00, 5, 5.00",
            "3.67, 1, 3.67",
            "4.57, 2, 9.14"
    })
    void testCostProduct(double price, int quantity, double expectResult) {
        Product product = new Product(2, "salt", price);
        assertTrue(Math.abs(product.getCost(quantity) - expectResult) < 0.00000001);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.01, 0.0505",
            "2.51, 0.1255",
            "1.62, 0.081",
            "3.67, 0.1835",
            "4.57, 0.2285"
    })
    void testTaxForProductWithDiscountCard(double price, double expectTax) {
        AbstractProduct product = new Product(4, "milk", price);
        product = new DiscountForCard(product);
        assertTrue(Math.abs(product.getTax() + expectTax) <= 0.00001);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.01, 0.101",
            "2.51, 0.251",
            "1.62, 0.162",
            "3.67, 0.367",
            "4.57, 0.457"
    })
    void testTaxForProductWithPromotion(double price, double expectTax) {
        AbstractProduct product = new Product(4, "milk", price, true);
        product = new DiscountPromotionProduct(product);
        assertTrue(Math.abs(product.getTax() + expectTax) <= 0.00001);
    }

    @Test
    void testBasketIsEmpty() {
        Customer customer = new Customer();
        Basket basket = customer.counstructBasket();
        assertTrue(basket.getBasketList().isEmpty());
    }

    @Test
    void testCostBasketWithoutPromotionAndDiscountCard() {
        Basket basket = new Basket();
        basket.putProduct(new Product(1, "milk", 1.26), 2);
        basket.putProduct(new Product(2, "bread", 1.01), 1);
        basket.putProduct(new Product(3, "butter", 2.5), 6);
        basket.costBasket();
        assertTrue(Math.abs(basket.getTotal() - 18.53) <= 0.0001);
        assertTrue(Math.abs(basket.getTotalTax() + 0.0) <= 0.0001);
        assertTrue(Math.abs(basket.getFinalTotal() - 18.53) <= 0.0001);
    }

    @Test
    void testCostBasketWithPromotionProduct() {
        Basket basket = new Basket();
        basket.putProduct(new Product(1, "milk", 1.26), 2);
        basket.putProduct(new Product(2, "bread", 1.01), 1);
        basket.putProduct(new Product(3, "butter", 2.5, true), 6);
        basket.costBasket();
        assertTrue(Math.abs(basket.getTotal() - 18.53) <= 0.0001);
        assertTrue(Math.abs(basket.getTotalTax() + 1.5) <= 0.0001);
        assertTrue(Math.abs(basket.getFinalTotal() - 17.03) <= 0.0001);
    }

    @Test
    void testCostBasketWithPromotionProductAndDiscountCard() {
        Basket basket = new Basket();
        basket.putProduct(new Product(1, "milk", 1.26), 2);
        basket.putProduct(new Product(2, "bread", 1.01), 1);
        basket.putProduct(new Product(3, "butter", 2.5, true), 6);
        basket.setDiscountCard(new DiscountCard(1234));
        basket.costBasket();
        assertTrue(Math.abs(basket.getTotal() - 18.53) <= 0.0001);
        assertTrue(Math.abs(basket.getTotalTax() + 1.6765) <= 0.00001);
        assertTrue(Math.abs(basket.getFinalTotal() - 16.8535) <= 0.00001);
    }
}