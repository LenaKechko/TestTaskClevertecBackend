package org.store.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.store.customer.Basket;
import org.store.customer.BasketBuilder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasketBuilderTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 751})
    void testCorrectAddDiscountCard(int number) {
        BasketBuilder builder = new BasketBuilder();
        builder.addDiscountCard(number);
        Basket basket = builder.getBasket();
        assertNotNull(basket.getNumberDiscountCard());
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 71})
    void testNotCorrectAddDiscountCard(int number) {
        BasketBuilder builder = new BasketBuilder();
        builder.addDiscountCard(number);
        Basket basket = builder.getBasket();
        assertNull(basket.getNumberDiscountCard());
        assertEquals("Discount card isn't correct",
                output.toString().trim());
    }

    @Test
    void testCorrectAddProductInBasket() {
        Map<Integer, Integer> shoppingList = new HashMap<>() {{
            put(1,2);
            put(3,5);
        }};
        BasketBuilder builder = new BasketBuilder();
        builder.addProductIntoBasket(shoppingList);
        Basket basket = builder.getBasket();
        assertEquals(basket.getBasketList().size(), 2);
    }
    @Test
    void testNotCorrectAddProductInBasket() {
        Map<Integer, Integer> shoppingList = new HashMap<>() {{
            put(11,2);
            put(12,5);
        }};
        BasketBuilder builder = new BasketBuilder();
        builder.addProductIntoBasket(shoppingList);
        Basket basket = builder.getBasket();
        assertTrue(basket.getBasketList().isEmpty());
    }
}