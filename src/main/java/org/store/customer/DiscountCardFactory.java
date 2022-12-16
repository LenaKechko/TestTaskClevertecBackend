package org.store.customer;

import java.util.Arrays;
import java.util.List;

public class DiscountCardFactory {
    private static List<DiscountCard> cardList = Arrays.asList(
            new DiscountCard(1234),
            new DiscountCard(654),
            new DiscountCard(751),
            new DiscountCard(9871));

    public static List<DiscountCard> getCardList() {
        return cardList;
    }
}
