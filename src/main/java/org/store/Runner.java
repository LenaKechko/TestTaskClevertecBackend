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
        ManagedTask managedTask = new ManagedTask(requestCustomer);
    }
}