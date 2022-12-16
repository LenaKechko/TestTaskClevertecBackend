package org.store;

import org.store.customer.Basket;
import org.store.customer.Customer;
import org.store.sale.Receipt;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String text = sc.nextLine();
        String text = "1-2 2-1 3-6";
        int numberDiscountCard = -1;
        if (text.contains("Card")) {
            text = text.split(" Card-")[0];
            numberDiscountCard = Integer.parseInt(text.split(" Card-")[1]);
        }
        Map<Integer, Integer> shoppingList =
                Stream.of(text.split(" "))
                        .map(x -> x.split("-"))
                        .collect(Collectors.toMap(x -> Integer.parseInt(x[0]), x -> Integer.parseInt(x[1])));

        shoppingList.entrySet().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        Customer customer = new Customer(numberDiscountCard);
        customer.addProduct(shoppingList);
        Basket basket = customer.counstructBasket();
        System.out.println(basket.getBasketList());
        Receipt bill = new Receipt(basket);
        System.out.println(bill.construct());
    }
}