package org.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
//        SpringApplication.run(Runner.class, args);
//        args = new String[]{"1-2", "2-1", "3-6", "Card-1234"};
//        String requestCustomer = String.join(" ", args);
        String requestCustomer = "1-2 2-1 3-6 Card-1234";
        ManagedTask managedTask = new ManagedTask(requestCustomer);
    }
}