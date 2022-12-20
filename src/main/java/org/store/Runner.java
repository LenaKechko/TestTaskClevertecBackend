package org.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.store.customer.Basket;
import org.store.customer.Customer;
import org.store.repository.ProductRepository;
import org.store.sale.ProductFactory;
import org.store.sale.Receipt;
import org.store.services.ProductService;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
//        args = new String[]{"1-2", "2-1", "3-6", "Card-1234"};
//        String requestCustomer = String.join(" ", args);
        String requestCustomer = "1-2 2-1 3-6 Card-1234";
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