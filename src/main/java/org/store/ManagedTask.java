package org.store;

import org.store.customer.Basket;
import org.store.customer.Customer;
import org.store.sale.Receipt;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManagedTask {
    public ManagedTask(String requestCustomer) {
        if (checkInputData(requestCustomer)) {
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
            if (basket.getBasketList().isEmpty()) {
                System.out.println("Basket is empty");
                return;
            }
            Receipt bill = new Receipt(basket);
            Receipt.printReceipt(bill.construct());
        }
    }

    public static boolean checkInputData(String requestCustomer) {
        if (requestCustomer.isEmpty()) {
            System.out.println("Customer don't have product in basket and don't have discount card");
            return false;
        }
        if (requestCustomer.toLowerCase().indexOf("card") == 0) {
            System.out.println("Customer don't have product in basket, only discount card");
            return false;
        }
        return true;
    }
}
