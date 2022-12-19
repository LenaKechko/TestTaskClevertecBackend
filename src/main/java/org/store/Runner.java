package org.store;

import org.store.customer.Basket;
import org.store.customer.Customer;
import org.store.sale.Receipt;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
//        args = new String[]{"1-2", "2-1", "3-6", "Card-1234"};
//        String requestCustomer = String.join(" ", args);
        String requestCustomer = "1-2 2-1 3-6 Card-1234";
        int numberDiscountCard = -1;
        if (requestCustomer.contains("Card")) {
            numberDiscountCard = Integer.parseInt(requestCustomer.split(" Card-")[1]);
            requestCustomer = requestCustomer.split(" Card-")[0];
        }
        Map<Integer, Integer> shoppingList =
                Stream.of(requestCustomer.split(" "))
                        .map(x -> x.split("-"))
                        .collect(Collectors.toMap(x -> Integer.parseInt(x[0]), x -> Integer.parseInt(x[1])));

        Customer customer = new Customer(numberDiscountCard);
        customer.addProduct(shoppingList);
        Basket basket = customer.counstructBasket();
        Receipt bill = new Receipt(basket);
        Receipt.printReceipt(bill.construct());
    }
}