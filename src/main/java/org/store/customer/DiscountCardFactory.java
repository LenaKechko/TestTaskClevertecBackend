package org.store.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.store.services.DiscountCardService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
public abstract class DiscountCardFactory {
    /*работа без файла и бд*/
//        private static List<DiscountCard> cardList = Arrays.asList(
//            new DiscountCard(1234),
//            new DiscountCard(654),
//            new DiscountCard(751),
//            new DiscountCard(9871));

    /*работа с файлом*/
    private static List<DiscountCard> cardList = new ArrayList<>();

    static {
        File file = new File("Discount_card.txt");
        try (FileReader input = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(input);
            String line = "";
            while ((line = reader.readLine()) != null) {
                cardList.add(new DiscountCard(Integer.parseInt(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static List<DiscountCard> cardList = new ArrayList<>();
//
//    @Autowired
//    private static DiscountCardService discountCardService;
//
//    static {
//        discountCardService.findAll();
//        cardList.addAll(discountCardService.findAll());
//        Arrays.stream(new List[]{discountCardService.findAll()}).forEach(System.out::println);
//    }

    public static List<DiscountCard> getCardList() {
        return cardList;
    }
}
