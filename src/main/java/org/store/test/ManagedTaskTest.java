package org.store.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.store.ManagedTask;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ManagedTaskTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testResultNullDataFromUser() {
        String requestCustomer = "";
        assertFalse(ManagedTask.checkInputData(requestCustomer));
    }

    @Test
    void testNullDataFromUser() {
        String requestCustomer = "";
        ManagedTask.checkInputData(requestCustomer);
        assertEquals("Customer don't have product in basket and don't have discount card",
                output.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Card-1234", "card-1234"})
    void testResultWithoutCardDataFromUser(String requestCustomer) {
        assertFalse(ManagedTask.checkInputData(requestCustomer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Card-1234", "card-1234"})
    void testWithoutCardDataFromUser(String requestCustomer) {
        ManagedTask.checkInputData(requestCustomer);
        assertEquals("Customer don't have product in basket, only discount card",
                output.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1-5 Card-1234", "1-5"})
    void testCorrectDataFromUser(String requestCustomer) {
        assertTrue(ManagedTask.checkInputData(requestCustomer));
    }
}