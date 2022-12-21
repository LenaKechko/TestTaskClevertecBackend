package org.store.customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<DiscountCard> getCardList() {
        return cardList;
    }
}
